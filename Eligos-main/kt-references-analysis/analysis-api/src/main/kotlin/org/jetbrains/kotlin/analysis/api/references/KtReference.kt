package org.jetbrains.kotlin.analysis.api.references

import org.jetbrains.kotlin.analysis.api.symbols.KtSymbol

interface KtReference {
    fun resolveToSymbol(): KtSymbol?
}

val org.jetbrains.kotlin.psi.KtReferenceExpression.mainReference
    get() = object : KtReference {
        override fun resolveToSymbol(): KtSymbol? {
            TODO("Not implemented yet")
        }
    }
