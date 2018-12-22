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