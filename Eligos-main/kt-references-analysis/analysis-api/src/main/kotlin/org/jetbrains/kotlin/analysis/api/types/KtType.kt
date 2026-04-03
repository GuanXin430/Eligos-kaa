package org.jetbrains.kotlin.analysis.api.types

import org.jetbrains.kotlin.analysis.api.symbols.KtClassLikeSymbol

interface KtType {
    val isMarkedNullable: Boolean
    fun isDynamic(): Boolean
    val arguments: List<KtTypeArgument>
    fun isFlexible(): Boolean
    fun upperIfFlexible(): KtType
    fun lowerIfFlexible(): KtType
    val expandedTypeSymbol: KtClassLikeSymbol?
}

interface KtTypeArgument {
    val type: KtType
    val isStar: Boolean
}

object KtTypeArgument {
    object Star : KtTypeArgument {
        override val type: KtType
            get() = TODO("Not implemented yet")
        override val isStar: Boolean
            get() = true
    }
}
