package vn.thonghkk.noteapp.local.db.entities

import androidx.room.Entity
import vn.thonghkk.noteapp.internal.enum.BackgroundColorOfTaskEnum
import vn.thonghkk.noteapp.internal.enum.StateOfTaskEnum
import java.util.*

@Entity(tableName = "task", primaryKeys = ["id"])
data class TaskEntity(
    var name: String? = "",
    var description: String? = "",
    var backgroundColor: BackgroundColorOfTaskEnum = BackgroundColorOfTaskEnum.DEFAULT_COLOR,
    var stateOfTask: StateOfTaskEnum = StateOfTaskEnum.NEW,
    var createdTime: Long = System.currentTimeMillis(),
    var id: UUID = UUID.randomUUID(),
)