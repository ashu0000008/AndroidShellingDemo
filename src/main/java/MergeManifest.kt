import org.dom4j.Document
import org.dom4j.Element
import org.dom4j.io.OutputFormat
import org.dom4j.io.SAXReader
import org.dom4j.io.XMLWriter
import java.io.File
import java.io.FileOutputStream

import java.io.OutputStreamWriter

class MergeManifest {
    companion object {
        private const val TAG_APPLICATION = "application"
        private const val TAG_METADATA = "meta-data"

        fun merge(shellPath: String, apkPath: String, outputPath: String) {
            val shellRoot = getXmlRoot(shellPath)
            val apkRoot = getXmlRoot(apkPath)

            //replace shell application
            val shellApplication = shellRoot.element(TAG_APPLICATION)
            val apkApplication = apkRoot.element(TAG_APPLICATION)

            for (element in shellApplication.elementIterator()) {
                if (element.name != TAG_METADATA) {
                    shellApplication.remove(element)
                }
            }
            for (element in apkApplication.elementIterator()) {
                apkApplication.remove(element)
                shellApplication.add(element)
            }

            apkRoot.remove(apkApplication)
            shellRoot.remove(shellApplication)
            apkRoot.add(shellApplication)

            val format: OutputFormat = OutputFormat.createPrettyPrint()
            format.encoding = "UTF-8"
            val writer = XMLWriter(
                OutputStreamWriter(FileOutputStream(outputPath)), format
            )
            writer.write(apkRoot)
            writer.close()
        }

        private fun getXmlRoot(filePath: String): Element {
            val reader = SAXReader()
            val file = File(filePath)
            val document: Document = reader.read(file)
            return document.rootElement
        }

        fun replace(apkPath: String, outputPath: String){
            Runtime.getRuntime().exec("delete $apkPath")
            Thread.sleep(500)
            Runtime.getRuntime().exec("copy $outputPath $apkPath")
            Thread.sleep(500)
        }
    }
}