fun main() {
    println("main start")
    val ret = ExecBAT.exec("./decompile.bat")
    println("decompile.bat exec result:$ret")

    println("merge manifest start")
    MergeManifest.merge("data/shell/AndroidManifest.xml", "data/demo/AndroidManifest.xml")
    println("merge manifest end")

    MergeDex.doMerge("data/shell.dex", "data/demo.apk", "data/target.dex")
    println("main end")
}