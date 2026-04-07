package com.github.tnoalex.processor.utils

import org.jetbrains.kotlin.descriptors.ConstructorDescriptor
import org.jetbrains.kotlin.descriptors.DeclarationDescriptor
import org.jetbrains.kotlin.descriptors.FunctionDescriptor
import org.jetbrains.kotlin.descriptors.VariableDescriptor
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.getChildrenOfType
import org.jetbrains.kotlin.resolve.BindingContext

// 暂时提供一个空的BindingContext实现
val KtElement.bindingContext: BindingContext
    get() = BindingContext.EMPTY

fun KtNamedFunction.resolveToDescriptorIfAny(): FunctionDescriptor? {
    return null
}

fun KtProperty.resolveToDescriptorIfAny(): VariableDescriptor? {
    return null
}

fun KtConstructor<*>.resolveToDescriptorIfAny(): ConstructorDescriptor? {
    return null
}

fun KtDeclaration.resolveToDescriptorIfAny(): DeclarationDescriptor? {
    return null
}

fun KtExpression.referenceExpressionSelfOrInChildren(): List<KtReferenceExpression> {
    val result = ArrayList<KtReferenceExpression>()
    if (this is KtReferenceExpression)
        result.add(this)
    result.addAll(this.getChildrenOfType<KtReferenceExpression>())
    return result
}

val KtClass.superTypes
    get() = emptyList<org.jetbrains.kotlin.types.KotlinType>()

val KtObjectDeclaration.superTypes
    get() = emptyList<org.jetbrains.kotlin.types.KotlinType>()
