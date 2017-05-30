module.exports = function (grunt) {
    /**
     * 所有'js/app/{package}/main.js'文件都将被压缩成对应的{package}.min.js文件.
     */
    var mainJsList = grunt.file.expand('js/app/**/main.js');
    var angular = {};
    if (mainJsList.length > 0) {
        for (var i = 0; i < mainJsList.length; i++) {
            var path = mainJsList[i].replace(/\/main\.js/, '');
            var name = path.substr(path.lastIndexOf('/') + 1);
            requirejsTasks['task-' + name] = {
                options: {
                    baseUrl: path,                     //js根目录
                    name: 'main',                           //执行的第一个requirejs包
                    optimize: 'uglify2',
                    //optimize: 'none',
                    removeCombined: false,               // 删除被压缩的文件
                    preserveLicenseComments: false,     // 不保留License信息
                    mainConfigFile: 'js/app/' + name + '/main.js',                 //requirejs的配置文件
                    out: 'js/' + name + '.min.js',                 //输出的压缩文件
                    findNestedDependencies: true,                               //必须指定让requirejs能找到嵌套的文件
                    include: ['../../../node_modules/requirejs/require.js']                          //指定requirejs所在的位置。
                }
            };
        }
    }

    /**
     * processhtml
     *
     * 所有的index.html将被替换，转换成引用压缩之后的js和css。
     */
    var indexHtmlList = grunt.file.expand('views/**/index.html');
    var processHtmlTask = {
        dist: {
            files: {}
        }
    };
    for (var i = 0; i < indexHtmlList.length; i++) {
        var fileName = indexHtmlList[i];
        processHtmlTask.dist.files[fileName] = [fileName];
    }

    /**
     * htmlmin
     *
     * 所有的html文件都将被压缩。
     */
    var allHtmlFileList = grunt.file.expand('views/**/*.html');
    var commonHtmlFileList = grunt.file.expand('js/core/**/*.html');
    var htmlMinTask = {
        dist: {
            options: {
                removeComments: true,
                collapseWhitespace: true
            },
            files: {}
        }
    };
    for (var i = 0; i < allHtmlFileList.length; i++) {
        var fileName = allHtmlFileList[i];
        htmlMinTask.dist.files[fileName] = fileName;
    }

    /**
     * 将所有的css进行压缩，然后去掉没有用到的样式。
     */
    var uncssIgnores = [// needed for Bootstrap's transitions
        '.bs.carousel',
        '.slid.bs.carousel',
        '.slide.bs.carousel',
        '.fade',
        '.fade.in',
        '.collapse',
        '.collapse.in',
        '.collapsing',
        '.alert-danger',
        '.logged-in .navbar-default',
        '.carousel-inner > .next',
        '.carousel-inner > .prev',
        '.carousel-inner > .next',
        '.carousel-inner > .prev',
        '.carousel-inner > .next.left',
        '.carousel-inner > .prev.right',
        '.carousel-inner > .active.left',
        '.carousel-inner > .active.right',
        '.modal.in .modal-dialog',
        '.btn-default',
        '.btn-danger',
        '.btn-info',
        '.btn-primary',
        '.show-block',
        '.hide',
        '.expand-true',
        '.expand-false',
        '.selected',
        '.active',
        '.index-body1-bottom-box',
        '[role="presentation"].active [data-toggle="tab"]',
        'li[role="presentation"]',
        '.weekend',
        '.on',
        '.disabled-feature',
        '.forum-show-scroll',
        '.index-head-menu-dropdown li',
        '.index-head-menu li',
        '.expand-true',
        '.ui-sortable-handle',
        '.ui-front',
        '.sign-record-color',
        '.label-new',
        '.staff-exist',
        '.staff-name-match',
        '.job-offer-padding-7',
        '.job-offer-padding-7',
        /\.day.*/,
        /\.glyphicon.*/,
        /\.lina-tree.*/,
        /\.jstree.*/,
        /\.jstree-/,
        /\.label.*/,
        /\.label_box/,
        /\.label_box1/,
        /\.tip-box.*/,
        /\.open.*/,
        /\.table-div.*/,
        /\.nav-tabs.*/,
        /\.nav1.*/,
        /\.*index.*/,
        /\[role=presentation]\.active.*/,
        /\.input-append.*/,
        /\.ke-.*/,
        /\.col-.*/,
        /\.ui-widget.*/,
        /\.ui-menu.*/,
        /\.ui-autocomplete.*/,
        /\.input-group.*/,
        /\.xdsoft.*/,
        /\.ri.*/,
        /\.new-.*/,
        /\.form-control\[disabled].*/,
        /\.popover-.*/,
        /\.clockpicker-.*/,
        /\.add.*/,
        /.*\.active.*/,
        /\.tooltip.*/,
        /\.fade.*/,
        /\.modal-backdrop.*/,
        /\.inform.*/,
        /\.modal.*/,
        /\.btn.disabled.*/,
        /.*\[disabled].*/
    ];
    var uncssTasks = {};
    for (var i = 0; i < allHtmlFileList.length; i++) {
        var fileName = allHtmlFileList[i];
        var start = fileName.indexOf("/") + 1;
        var len = fileName.indexOf("/", start + 1) - start;
        var moduleName = fileName.substr(start, len);
        var taskName = "dist-" + moduleName;
        if (!uncssTasks[taskName]) {
            uncssTasks[taskName] = {
                options: {
                    ignore: uncssIgnores,
                    stylesheets: ["css/" + moduleName + ".combined.css"],
                    csspath: "../../"
                },
                files: {}
            };
            uncssTasks[taskName].files["css/" + moduleName + ".tidy.css"] = ["view/" + moduleName + "/index.html"].concat(commonHtmlFileList);
        }
        if (fileName.indexOf("index.html") < 0) {
            uncssTasks[taskName].files["css/" + moduleName + ".tidy.css"].push(fileName);
        }
    }

    /**
     * cssmin
     *
     * 对css进行压缩
     */
    var cssMinTask = {
        options: {
            advanced: false,
            shorthandCompacting: false,
            roundingPrecision: -1,
            rebase: true,
            debug: false,
            processImport: true
        },
        concat: {
            'files': {}
        },
        minify: {
            'files': {}
        }
    };
    var cssMinFileList = grunt.file.expand('css/module/*.css');
    for (var i = 0; i < cssMinFileList.length; i++) {
        var fileName = cssMinFileList[i];
        var start = fileName.lastIndexOf("/") + 1;
        var len = fileName.lastIndexOf(".") - start;
        var moduleName = fileName.substr(start, len);
        cssMinTask.concat.files['css/' + moduleName + '.combined.css'] = [fileName];
        cssMinTask.minify.files['css/' + moduleName + '.min.css'] = ['css/' + moduleName + '.combined.css'];
    }

    var filerevTasks = {
        js: {
            src: 'js/*.min.js'
        },
        css: {
            src: 'css/*.min.css'
        }
    };

    var useMinTasks = {
        html: ['view/**/*.html']
    };

    var manifestTasks = {
        generate: {
            options: {
                basePath: ".",
                verbose: true
            },
            src: ['js/*.min.*.js', 'css/*.min.*.css', 'img/**/*']
        }
    };

    var cleanTasks = {
        old: ['js/*.min.*.js', 'js/*.min.js', 'css/*.combined.*.css', 'css/*.combined.css',
            'css/*.tidy.css', 'css/*.tidy.*.css', 'css/*.min.*.css', 'css/*.min.css'],
        outdated: ['js/**/*.js', '!js/core/main-init.js', '!js/plugins/jquery/dist/jquery.min.js', '!js/*.min.*.js', '!css/common.css', '!css/reset.css', '!css/login.css', '!css/*.min.*.css',
            'Gruntfile.js', 'npm-debug.log', 'package.json']
    };

    var concurrentTaskOptions = {
        logConcurrentOutput: true,
        limit: 4
    };
    var concurrentTasks = {
        requirejs: {
            tasks: [],
            options: concurrentTaskOptions
        },
        uncss: {
            tasks: [],
            options: concurrentTaskOptions
        }
    };
    for (var task in requirejsTasks) {
        concurrentTasks.requirejs.tasks.push('requirejs:' + task);
    }
    for (var task in uncssTasks) {
        concurrentTasks.uncss.tasks.push('uncss:' + task);
    }

    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),     //指定包的信息
        processhtml: processHtmlTask,
        htmlmin: htmlMinTask,
        cssmin: cssMinTask,
        uncss: uncssTasks,
        requirejs: requirejsTasks,
        filerev: filerevTasks,
        usemin: useMinTasks,
        manifest: manifestTasks,
        clean: cleanTasks,
        concurrent: concurrentTasks
    });

    //加载所需要的库
    grunt.loadNpmTasks('grunt-contrib-requirejs');
    grunt.loadNpmTasks("grunt-contrib-cssmin");
    grunt.loadNpmTasks('grunt-contrib-htmlmin');
    grunt.loadNpmTasks('grunt-processhtml');
    grunt.loadNpmTasks('grunt-uncss');
    grunt.loadNpmTasks('grunt-usemin');
    grunt.loadNpmTasks('grunt-filerev');
    grunt.loadNpmTasks('grunt-manifest');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-concurrent');

    //注册相应的类库
    grunt.registerTask('default', ['clean:old', 'concurrent:requirejs', 'cssmin:concat',
        'cssmin:minify', 'processhtml', 'htmlmin', 'filerev', 'usemin', 'clean:outdated']);
};
