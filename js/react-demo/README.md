This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.<br>
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.<br>
You will also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.<br>
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.<br>
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.<br>
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can’t go back!**

If you aren’t satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (Webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you’re on your own.

You don’t have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn’t feel obligated to use this feature. However we understand that this tool wouldn’t be useful if you couldn’t customize it when you are ready for it.

## Learn More

You can learn more in the [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started).

To learn React, check out the [React documentation](https://reactjs.org/).




---

# 一、安装

## Create React App
### You’ll need to have Node >= 6 and npm >= 5.2 on your machine

1. 产看node版本，没安装的请先安装；　　　　

    $node -v

2. 清除node缓存；

    $sudo npm cache clean -f  

3. 安装node版本管理工具'n';

    $sudo npm install n -g

4. 使用版本管理工具安装指定node或者升级到最新node版本；

    $sudo n stable  （安装node最新版本）
    $sudo n 8.9.4 （安装node指定版本8.9.4）

5. 使用node -v查看node版本，如果版本号改变为你想要的则升级成功。

### 若版本号未改变则还需配置node环境变量

1. 查看通过n安装的node的位置；

    通过n安装完node后会打印安装位置
    
        install : node-v11.4.0
               mkdir : /usr/local/n/versions/node/11.4.0
               fetch : https://nodejs.org/dist/v11.4.0/node-v11.4.0-linux-x64.tar.gz
        ######################################################################## 100.0%
           installed : v11.4.0


2. cd进入/usr/local/n/versions/node/ 你应该能看到你刚通过n安装的node版本这里如：8.9.4；编辑/etc/profile;

    $vim /etc/profile

3. 将node安装的路径（这里为：/usr/local/n/versions/node/8.9.4）添加到文件末尾；

    export NODE_HOME=/usr/local/n/versions/node/8.9.4
    export PATH=$NODE_HOME/bin:$PATH

4. wq退出保存文件，编译/etc/profile;

    $source /etc/profile
    
5.　再次使用node -v查看node版本，不出意外版本号应该变为你想要的。

### npm 升级

如果不是最新版本，运行一下代码即可。

运行指令

    npm install -g npm
    
这样npm就更新到最新版本了。

### Create React App

        npx create-react-app react-demo-app
        cd my-app
        npm start

* When you’re ready to deploy to production, running npm run build will create an optimized build of your app in the build folder

## 相关技术栈

### Next.js

Next.js is a popular and lightweight framework for static and server‑rendered applications built with React. It includes styling and routing solutions out of the box, and assumes that you’re using Node.js as the server environment.

### Gatsby

Gatsby is the best way to create static websites with React.

### More Flexible Toolchains


# Learn by dong

* 组件　





# JSX
* 表达式{}
* 同样推荐在 JSX 代码的外面扩上一个小括号，这样可以防止 分号自动插入 的 bug
* JSX 本身其实也是一种表达式,在编译之后呢，JSX 其实会被转化为普通的 JavaScript 对象.

## JSX属性

* 以字符串为值的属性,使用引号
* 以JavaScript表达式为值的属性，使用{}

## JSX嵌套

## JSX 代表 Objects

* Babel 转译器会把 JSX 转换成一个名为 React.createElement() 的方法调用。

# 元素渲染

* 元素是构成 React 应用的最小单位

## 将元素渲染到 DOM 中

* 根节点
　　　　我们用React 开发应用时一般只会定义一个根节点。但如果你是在一个已有的项目当中引入 React 的话，你可能会需要在不同的部分单独定义 React 根节点。

* 我们通过把它们都传递给 ReactDOM.render() 的方法来将其渲染到页面上

