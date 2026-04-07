package org.jetbrains.kotlin.analysis.project.structure

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.PsiElement

public interface ProjectStructureProvider {
    public fun getKtModule(element: PsiElement): KtModule
    
    public companion object {
        public fun getModule(project: Project, element: PsiElement, useSiteModule: KtModule): KtModule {
            // 简单实现，返回一个默认的KtModule
            return object : KtModule {
                override val project = project
                override val moduleDescription = "Default module"
                override val directRegularDependencies = emptyList<KtModule>()
                override val directDependsOnDependencies = emptyList<KtModule>()
                override val transitiveDependsOnDependencies = emptyList<KtModule>()
                override val directFriendDependencies = emptyList<KtModule>()
                override fun containsFile(file: VirtualFile): Boolean {
                    return false
                }
                override fun allDirectDependencies(): List<KtModule> {
                    return emptyList()
                }
            }
        }
    }
}

public class KotlinResolutionScopeProvider private constructor(private val project: Project) {
    companion object {
        public fun getInstance(project: Project): KotlinResolutionScopeProvider {
            return KotlinResolutionScopeProvider(project)
        }
    }
    
    public fun getResolutionScope(module: KtModule): GlobalSearchScope {
        return GlobalSearchScope.allScope(project)
    }
}