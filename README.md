## 这是软工三第35小组"吉特Fan"的项目GitSearch.

-----------
**注意：4月6日提交的版本中有bug不能查看合作者与贡献者统计，在4月17日的12点28分左右的提交中修复了，请检查时使用那个版本的jar文件，造成不便十分抱歉**

-----------
master分支是成品分支，其它分支都是开发用的分支，项目目录下的GitSearch-0.9.jar是迭代一的成品，GitSearch-1.2.jar是迭代二的成品。
> 迭代一说明：GitSearch-0.9.jar可以直接运行，已经将所有资源文件和依赖包打包进去了。

> 迭代二说明：GitSearch-1.2.jar可以运行，相关依赖为项目目录下的lib目录下的所有jar包，部署的时候需要将GitSearch-1.2.jar和lib文件夹及其中文件放在同一
目录下。具体使用请参照document目录下的部署文档。

项目源代码在src目录下，为maven项目结构，通过将项目目录下的jfoenix-1.0.jar（maven库中没有的第三方jar包）
添加到本地maven仓库，就可以通过maven install来打包。GitSearch-1.2.jar及lib目录下的
依赖jar文件就是这样生成的。


