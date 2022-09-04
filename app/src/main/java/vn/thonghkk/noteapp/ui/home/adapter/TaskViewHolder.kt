package vn.thonghkk.noteapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import vn.thonghkk.noteapp.R
import vn.thonghkk.noteapp.databinding.ItemTaskToDoBinding
import vn.thonghkk.noteapp.internal.enum.BackgroundColorOfTaskEnum
import vn.thonghkk.noteapp.local.db.entities.TaskEntity

class TaskViewHolder(val viewBinding: ItemTaskToDoBinding): RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(task: TaskEntity) {
        viewBinding.task = task
        viewBinding.backgroundTask = when(task.backgroundColor) {
            BackgroundColorOfTaskEnum.DEFAULT_COLOR -> {
                ContextCompat.getColor(itemView.context, R.color.default_color_task)
            }
            BackgroundColorOfTaskEnum.BLUE_COLOR -> {
                ContextCompat.getColor(itemView.context, R.color.blue_color_task)
            }
            BackgroundColorOfTaskEnum.BLUE_LIGHT_COLOR -> {
                ContextCompat.getColor(itemView.context, R.color.blue_light_color_task)
            }
            BackgroundColorOfTaskEnum.BLUE_LIGHTEST_COLOR -> {
                ContextCompat.getColor(itemView.context, R.color.blue_lightest_color_task)
            }
        }
        viewBinding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): TaskViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemTaskToDoBinding.inflate(layoutInflater, parent, false)
            return TaskViewHolder(binding)
        }
    }
}