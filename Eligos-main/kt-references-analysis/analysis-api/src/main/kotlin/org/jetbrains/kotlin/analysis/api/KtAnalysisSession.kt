package org.jetbrains.kotlin.analysis.api

import org.jetbrains.kotlin.analysis.api.references.KtReference
import org.jetbrains.kotlin.analysis.api.types.KtType
import org.jetbrains.kotlin.psi.KtElement
import org.jetbrains.kotlin.psi.KtExpression
import org.jetbrains.kotlin.psi.KtReferenceExpression

interface KtAnalysisSession {
    fun <R> analyze(element: KtElement, action: KtAnalysisSession.() -> R): R
    fun KtExpression.getKtType(): KtType?
    fun KtExpression.getExpectedKtType(): KtType?
    val KtReferenceExpression.references: List<KtReference>
}

context(KtAnalysisSession)
fun <R> KtElement.analyze(action: KtAnalysisSession.() -> R): R {
    return this@KtAnalysisSession.analyze(this, action)
}

fun <R> KtElement.analyze(action: KtAnalysisSession.() -> R): R {
    TODO("Not implemented yet")
}
