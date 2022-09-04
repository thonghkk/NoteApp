package vn.thonghkk.noteapp.ui.home

import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import vn.thonghkk.noteapp.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import vn.thonghkk.noteapp.databinding.ActivityHomeBinding
import vn.thonghkk.noteapp.internal.enum.BackgroundColorOfTaskEnum
import vn.thonghkk.noteapp.internal.enum.StateOfTaskEnum
import vn.thonghkk.noteapp.local.db.entities.TaskEntity
import vn.thonghkk.noteapp.ui.home.adapter.TaskAdapter
import vn.thonghkk.noteapp.ui.home.adapter.TaskViewHolder
import java.util.*

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    private val taskAdapter = TaskAdapter()

    private val viewModel: HomeViewModel by viewModel()

    override fun getViewBinding(): ActivityHomeBinding {
        val viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        viewBinding.lifecycleOwner = this
        return viewBinding
    }

    override fun initUI() {
        super.initUI()
        binding.recycleViewTask.adapter = taskAdapter
    }

    override fun bindUI() {
        super.bindUI()
        viewModel.insertNewTask(
            TaskEntity(
                "Name Task 1",
                "Description Task 1",
                BackgroundColorOfTaskEnum.DEFAULT_COLOR,
                StateOfTaskEnum.DOING
            )
        )
        viewModel.listTask.observe(this, ::onHandleListTaskChange)
    }


    private fun onHandleListTaskChange(listTask: List<TaskEntity>?) {
        listTask?.let {
            taskAdapter.submitList(it)
            customDragDropTaskItem(it)
        }
    }


    fun onClickAddNewTask(view: View) {

    }

    private fun customDragDropTaskItem(listTask: List<TaskEntity>?) {
        val helper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT, ItemTouchHelper.ANIMATION_TYPE_SWIPE_CANCEL) {

            override fun getSwipeDirs (recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
                if (viewHolder is TaskViewHolder) return 0
                return super.getSwipeDirs(recyclerView, viewHolder)
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                //get position of locate currently  items
                val positionDragged = viewHolder.adapterPosition
                //get position of locate moved items
                val positionTarget = target.adapterPosition
                Collections.swap(listTask, positionDragged, positionTarget)
                taskAdapter.notifyItemMoved(positionDragged, positionTarget)
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            }
        })
        helper.attachToRecyclerView(binding.recycleViewTask)
    }

}