package com.ciniur.memorygame

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.ciniur.memorygame.databinding.FragmentGameBinding
import kotlinx.android.synthetic.main.fragment_game.*

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater, R.layout.fragment_game
            , container, false
        )
        binding.btnStart.setOnClickListener {
            val map = game(binding)
            var color: Int = -1
            var view: TextView = textView1
            for (item in map.keys) {
                item.setOnClickListener {
                    if (color == -1) {
                        it.setBackgroundColor(map.get(it)!!)
                        color = map.get(item)!!
                        view = item
                        Log.e("clicked", "you r in if 1")
                    }
                    else if (map.get(item)!! == color) {
                        view.isEnabled = false
                        it.isEnabled = false
                        it.setBackgroundColor(color)
                        color = -1
                        Log.e("clicked", "you r in if 2")
                    }
                    else {
                        Log.e("clicked", "you r in else")
                        color = -1
                        it.setBackgroundColor(Color.WHITE)
                        view.setBackgroundColor(Color.WHITE)
                    }
                }
            }
        }
        return binding.root
    }

    fun game(binding: FragmentGameBinding):Map<TextView,Int>{
        val list = initGame(binding)
        val randColor = randColor()
        var i =0
        val map :MutableMap<TextView,Int> = mutableMapOf()
            for (j in 0..list.size -1 step 2){
                Log.e("for","is working ${j}")
                map.put(list[j],randColor[i])
                map.put(list[j+1],randColor[i])
                list[j].setBackgroundColor(randColor[i])
                list[j+1].setBackgroundColor(randColor[i++])
            }

        Handler().postDelayed({
                for ( item in list){
                    item.setBackgroundColor(Color.WHITE)
                }
            }, 4000)

        return  map
    }
    fun initGame(binding: FragmentGameBinding):MutableList<TextView>{

        val list  = mutableListOf(textView1,textView2,textView3,textView4,textView5,textView6,textView7
            ,textView8,textView9,textView10,textView11,textView12,textView13,textView14,textView15,textView16)
        for (item in list){
            item.setBackgroundColor(Color.WHITE)
        }
        list.shuffle()
        return list
    }
    fun randColor(): MutableList<Int>{
        val list= mutableListOf(
            Color.BLACK,
            Color.GRAY,
            Color.GREEN,
            Color.BLUE,
            Color.YELLOW,
            Color.CYAN,
            Color.MAGENTA,
            Color.LTGRAY)
        list.shuffle()
        return list
    }
}

