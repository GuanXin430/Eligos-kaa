package org.jetbrains.kotlin.analysis.api.symbols

import org.jetbrains.kotlin.analysis.api.types.KtType
import org.jetbrains.kotlin.psi.KtProperty

interface KtPropertySymbol : KtSymbol {
    val returnType: KtType?
    val psi: KtSymbolPsi?
}

val KtProperty.symbol
    get() = object : KtPropertySymbol {
        override fun getContainingSymbol(): KtSymbol? {
            TODO("Not implemented yet")
        }

        override val returnType: KtType?
            get() = TODO("Not implemented yet")

        override val psi: KtSymbolPsi?
            get() = object : KtSymbolPsi {
                override val filePath: String
                    get() = this@symbol.filePath

                override val startLine: Int
                    get() = this@symbol.startLine
            }
    }
