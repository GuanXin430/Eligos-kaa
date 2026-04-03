package org.jetbrains.kotlin.analysis.api.calls.smartcasts

import org.jetbrains.kotlin.analysis.api.KtAnalysisSession
import org.jetbrains.kotlin.psi.KtExpression

interface KtDataFlowValue {
    val nullability: KtNullability?
    companion object {
        fun create(expression: KtExpression, analysisSession: KtAnalysisSession): KtDataFlowValue? {
            return object : KtDataFlowValue {
                override val nullability: KtNullability? = KtNullability.UNKNOWN
            }
        }
    }
}

interface KtDataFlowValueFactory {
    fun create(expression: Any, analysisSession: Any): KtDataFlowValue?
}

enum class KtNullability {
    NOT_NULL,
    NULLABLE,
    UNKNOWN
}
