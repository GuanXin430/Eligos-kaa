package org.jetbrains.kotlin.analysis.project.structure

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

public interface KtModule {
    public val project: Project
    public val moduleDescription: String
    public val directRegularDependencies: List<KtModule>
    public val directDependsOnDependencies: List<KtModule>
    public val transitiveDependsOnDependencies: List<KtModule>
    public val directFriendDependencies: List<KtModule>
    public fun containsFile(file: VirtualFile): Boolean
    public fun allDirectDependencies(): List<KtModule>
}

public val VirtualFile.analysisExtensionFileContextModule: KtModule?
    get() = null

public annotation class KtModuleStructureInternals