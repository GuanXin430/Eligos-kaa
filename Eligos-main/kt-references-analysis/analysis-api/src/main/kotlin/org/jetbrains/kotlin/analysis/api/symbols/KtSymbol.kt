package org.jetbrains.kotlin.analysis.api.symbols

import org.jetbrains.kotlin.analysis.api.types.KtType

interface KtSymbol {
    fun getContainingSymbol(): KtSymbol?
}

interface KtClassLikeSymbol : KtSymbol {
}

interface KtPackageSymbol : KtSymbol {
}

interface KtFunctionSymbol : KtSymbol {
    val valueParameters: List<KtValueParameterSymbol>
    val psi: KtSymbolPsi?
    val name: KtSymbolName
}

interface KtValueParameterSymbol : KtSymbol {
    val returnType: KtType?
}



interface KtSymbolPsi {
    val filePath: String
    val startLine: Int
}

interface KtSymbolName {
    fun asString(): String
}
