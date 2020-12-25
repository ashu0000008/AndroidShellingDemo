import java.util.concurrent.TimeUnit

class ExecBAT {
    companion object {
        fun exec(path: String): Boolean {
            val runtime = Runtime.getRuntime()
            var success = false
            try {
                val retValue = runtime.exec(path)
                retValue.waitFor(60, TimeUnit.SECONDS)
                success = (0 == retValue.exitValue())
                retValue.destroy()
            } catch (e: Exception) {
                println(e.message)
            }
            return success
        }
    }
}