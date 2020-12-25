fun main() {
    println("main start")
    val ret = ExecBAT.exec("./decompile.bat")
    println("decompile.bat exec result:$ret")
    MergeDex.doMerge("data/shell.dex", "data/demo.apk", "data/target.dex")
    println("main end")
}