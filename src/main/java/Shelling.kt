fun main() {
    println("main start")
//    val ret = ExecBAT.exec("./decompile.bat")
//    val ret2 = ExecBAT.exec("./decompile2.bat")
//    println("decompile.bat exec result:$ret-$ret2")

    println("merge manifest start")
    MergeManifest.merge(
        "data/shell/AndroidManifest.xml",
        "data/demo/AndroidManifest.xml", "data/AndroidManifest.xml"
    )
    MergeManifest.replace("data\\demo\\AndroidManifest.xml", "data\\AndroidManifest.xml")
    println("merge manifest end")

    MergeDex.doMerge("data/shell.dex", "data/demo.apk", "data/target.dex")
    println("main end")
}