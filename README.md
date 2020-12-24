"# AndroidShellingDemo" 
步骤
1.将目标apk反编译
2.修改其中的AndroidManifest文件，将Application标签替换成壳的Application
3.重新打包生成新的apk
4.将壳程序中的dex文件和新apk合并，生成新的dex文件
5.将新dex文件替换到新的apk中
6.对新的apk进行字节对齐、签名
