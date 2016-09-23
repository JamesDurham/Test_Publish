package com.example.ap_and

import com.google.auto.service.AutoService
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement
import javax.lang.model.util.Elements
import javax.lang.model.util.Types
import javax.tools.Diagnostic

@SupportedAnnotationTypes("com.example.ap_and.annotation")
@AutoService(Processor::class)
class MyProcesser : AbstractProcessor() {
    private var tu: Types? = null
    private var eu: Elements? = null
    private var f: Filer? = null
    private var m: Messager? = null
    private var annotation_te: TypeElement? = null

    @Synchronized override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
        tu = processingEnv.typeUtils
        eu = processingEnv.elementUtils
        f = processingEnv.filer
        m = processingEnv.messager
        annotation_te = eu!!.getTypeElement("com.example.ap_and.annotation")
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latestSupported()
    }

    override fun process(annotations: Set<TypeElement>, roundEnv: RoundEnvironment): Boolean {
        for (element in roundEnv.getElementsAnnotatedWith(annotation_te)) {
            m!!.printMessage(Diagnostic.Kind.NOTE, "Element")
        }
        return true
    }
}
