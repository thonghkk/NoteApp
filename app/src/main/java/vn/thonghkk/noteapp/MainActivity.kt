package vn.thonghkk.noteapp

import vn.thonghkk.noteapp.base.BaseActivity
import vn.thonghkk.noteapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun getViewBinding(): ActivityMainBinding {
        val viewBinding = ActivityMainBinding.inflate(layoutInflater)
        viewBinding.lifecycleOwner = this

        return viewBinding
    }

}