package dev.feedforward.shiftopen

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.wm.ToolWindowId
import com.intellij.openapi.wm.ToolWindowManager

/* ctrl-0 */ class MessagesShiftOpen : ShiftOpen(ToolWindowId.MESSAGES_WINDOW)
/* ctrl-1 */ class ProjectShiftOpen : ShiftOpen(ToolWindowId.PROJECT_VIEW)
/* ctrl-2 */ class FavoritesShiftOpen : ShiftOpen(ToolWindowId.FAVORITES_VIEW)
/* ctrl-3 */ class FindShiftOpen : ShiftOpen(ToolWindowId.FIND)
/* ctrl-4 */ class RunShiftOpen : ShiftOpen(ToolWindowId.RUN)
/* ctrl-5 */ class DebugShiftOpen : ShiftOpen(ToolWindowId.DEBUG)
/* ctrl-6 */ class TodoShiftOpen : ShiftOpen(ToolWindowId.TODO_VIEW)
/* ctrl-7 */ class StructureShiftOpen : ShiftOpen(ToolWindowId.STRUCTURE_VIEW)
/* ctrl-8 */ class HierarchyShiftOpen : ShiftOpen(ToolWindowId.HIERARCHY)
/* ctrl-9 */ class VcsShiftOpen : ShiftOpen(ToolWindowId.VCS)

sealed class ShiftOpen(private val panelId: String) : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        ToolWindowManager.getInstance(project).getToolWindow(panelId)?.let {
            if (it.isVisible) {
                it.hide(null)
            } else {
                it.show(null)
            }
        }
    }
}
