package org.example

import com.intellij.openapi.editor.event.DocumentEvent
import com.intellij.openapi.editor.event.DocumentListener
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity

class KeyChangeListener : ProjectActivity {

    override suspend fun execute(project: Project) {
        val editorfactory = com.intellij.openapi.editor.EditorFactory.getInstance()

        editorfactory.eventMulticaster.addDocumentListener(
            object: DocumentListener {
                override fun documentChanged(event: DocumentEvent) {
                    val document = event.document
                    val file = FileDocumentManager.getInstance().getFile(document) ?: return

                    if(!file.name.contains(".dart")) return

                    val text = document.text

                    val keys = FlutterKeyParser.parseKeys(text)

                    val change = KeyDiffDetector.detectChange(file.path, keys)


                }
            }, project
        )
    }
}