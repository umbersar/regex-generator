package org.olafneumann.regex.generator.views

import javafx.scene.paint.Color
import javafx.scene.web.WebView
import org.olafneumann.regex.generator.RegexGeneratorProtocol
import tornadofx.*

class HTML5View : View() {
    companion object {
        private val flat = mixin {
            backgroundInsets += box(0.px)
            borderColor += box(Color.DARKGRAY)
        }
    }

    private val webView = WebView()
    private val engine = webView.engine

    override val root = borderpane {
        setPrefSize(800.0, 600.0)
        style {
            backgroundColor += c("#212529")
            textFill = c("#f8f9fa")
        }
        top {
            borderpane {
                center {
                    label {
                        textProperty().bind(titleProperty)
                        textFill = c("#f8f9fa")
                    }
                }
                right {
                    hbox {
                        button("•")
                        button("◯")
                        button("✕")
                    }
                }
            }
        }
        center = webView
    }


    init {
        printJavaInformation()

        // Automatically set the title of the window as the HTML document title
        titleProperty.bind(engine.titleProperty())
        // Show index.html from web module
        engine.load(RegexGeneratorProtocol.toRegexGeneratorProtocol("index.html"))
    }

    private fun printJavaInformation() {
        println("Java version:   ${System.getProperty("java.runtime.version")}")
        println("JavaFX version: ${System.getProperty("javafx.runtime.version")}")
        println("OS:             ${System.getProperty("os.name")} (${System.getProperty("os.arch")})")
        println("User agent:     ${engine.userAgent}")
    }

}