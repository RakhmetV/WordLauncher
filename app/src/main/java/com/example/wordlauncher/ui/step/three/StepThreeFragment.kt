package com.example.wordlauncher.ui.step.three

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.example.wordlauncher.R
import com.example.wordlauncher.StepActivity
import com.example.wordlauncher.checkBackState
import com.example.wordlauncher.data.datastep.WordForStep


class StepThreeFragment : Fragment() {
    lateinit var btn_anser_one: RelativeLayout
    lateinit var btn_anser_two: RelativeLayout
    lateinit var btn_anser_three: RelativeLayout
    lateinit var btn_anser_four: RelativeLayout

    lateinit var btn_anser_one_txt: TextView
    lateinit var btn_anser_two_txt: TextView
    lateinit var btn_anser_three_txt: TextView
    lateinit var btn_anser_four_txt: TextView

    lateinit var btn_result_one: RelativeLayout
    lateinit var btn_result_two: RelativeLayout
    lateinit var btn_result_three: RelativeLayout

    lateinit var btn_result_one_txt: TextView
    lateinit var btn_result_two_txt: TextView
    lateinit var btn_result_three_txt: TextView



    lateinit var btn_check: Button
    lateinit var word_in_one: TextView
    lateinit var word_in_two: TextView
    lateinit var word_in_three: TextView
    lateinit var exit: ImageView

    private var CurrentProgress = 0
    private var MaxProgress = 12
    lateinit var progressBar: ProgressBar
    var startTime: Long = 0
    var list_position = 0
    var position = 0
    var maxAnser = 2
    var counterAnser = 0
    var counterRightAnser = 0
    var btnCheckPosition = false

    var btn_alpha_answer = 0.2f
    var btn_alpha_result = 0.4f

    var checkBtnAnswer: ArrayList<Int> = arrayListOf(-1, -1, -1, -1)
    var listWord = arrayListOf<String>()
    var listWordStep = arrayListOf(
        arrayListOf<String>(),
        arrayListOf<String>(),
        arrayListOf<String>(),
        arrayListOf<String>(),
        arrayListOf<String>(),
        arrayListOf<String>(),
        arrayListOf<String>(),
        arrayListOf<String>(),
        arrayListOf<String>(),
        arrayListOf<String>(),
        arrayListOf<String>(),
        arrayListOf<String>(),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_step_three, container, false)
        checkBackState = "test"
        init(view)
        //выгрузка данных позиций
        startTime = System.currentTimeMillis()
        val sharedPreference =
            requireContext().getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)

        var themPosition = sharedPreference.getInt("them_position", 1)

        var stepPosition = sharedPreference.getInt("step_position", 1)

        //выгрузка списка слов для этого теста

        var WordList = WordForStep.WordStepList(themPosition, stepPosition)
        for (list in WordList) {
            listWord.add(list.word_en + "/:" + list.word_ru)
        }
        listWord.shuffle()
        addWordInTest() //Создаем массив из слов для теста
        workInTest() //работа теста
        btn_click(view)//Работа кнопок

        return view
    }

    fun setAnserBtn(indx: Int, str: String) {
        when (indx) {
            0 -> {
                btn_result_one.alpha = 1f
                btn_result_one_txt.text = str
            }
            1 -> {
                btn_result_two.alpha = 1f
                btn_result_two_txt.text = str
            }
            2 -> {
                btn_result_three.alpha = 1f
                btn_result_three_txt.text = str
            }
        }
    }

    fun setBackAnswer(str: String) {
        when (str) {
            btn_anser_one_txt.text.toString() -> {
                btn_anser_one.alpha = 1f
            }
            btn_anser_two_txt.text.toString() -> {
                btn_anser_two.alpha = 1f
            }
            btn_anser_three_txt.text.toString() -> {
                btn_anser_three.alpha = 1f
            }
            btn_anser_four_txt.text.toString() -> {
                btn_anser_four.alpha = 1f
            }
        }
        btn_check.isVisible = false
    }

    fun btn_click(view: View) {
        exit.setOnClickListener {
            AlertDialog.Builder(requireContext()).apply {
                setTitle("Confirmation")
                setMessage("All progress in this test will be lost.")

                setPositiveButton("Exit") { _, _ ->
                    val intent = Intent(requireContext(), StepActivity::class.java)
                    startActivity(intent)
                }

                setNegativeButton("Cancel"){_, _ ->
                }
                setCancelable(true)
            }.create().show()
        }
        btn_anser_one.setOnClickListener {
            if (counterAnser < maxAnser && btn_anser_one.alpha!=btn_alpha_answer) {

                for (i in checkBtnAnswer.withIndex()) {
                    if (checkBtnAnswer[i.index] == -1 && i.index < maxAnser) {
                        checkBtnAnswer[i.index] = 1
                        setAnserBtn(i.index, btn_anser_one_txt.text.toString())
                        break
                    }
                }


                counterAnser++
                if (counterAnser == maxAnser) {
                    btn_check.isVisible = true
                }
                btn_anser_one.alpha = btn_alpha_answer
            }

        }
        btn_anser_two.setOnClickListener {
            if (counterAnser < maxAnser && btn_anser_two.alpha!=btn_alpha_answer) {

                for (i in checkBtnAnswer.withIndex()) {
                    if (checkBtnAnswer[i.index] == -1 && i.index < maxAnser) {
                        checkBtnAnswer[i.index] = 1
                        setAnserBtn(i.index, btn_anser_two_txt.text.toString())
                        break
                    }
                }


                counterAnser++
                if (counterAnser == maxAnser) {
                    btn_check.isVisible = true
                }
                btn_anser_two.alpha = btn_alpha_answer
            }
        }
        btn_anser_three.setOnClickListener {
            if (counterAnser < maxAnser && btn_anser_three.alpha!=btn_alpha_answer) {

                for (i in checkBtnAnswer.withIndex()) {
                    if (checkBtnAnswer[i.index] == -1 && i.index < maxAnser) {
                        checkBtnAnswer[i.index] = 1
                        setAnserBtn(i.index, btn_anser_three_txt.text.toString())
                        break
                    }
                }


                counterAnser++
                if (counterAnser == maxAnser) {
                    btn_check.isVisible = true
                }
                btn_anser_three.alpha = btn_alpha_answer
            }
        }
        btn_anser_four.setOnClickListener {
            if (counterAnser < maxAnser && btn_anser_four.alpha!=btn_alpha_answer) {

                for (i in checkBtnAnswer.withIndex()) {
                    if (checkBtnAnswer[i.index] == -1 && i.index < maxAnser) {
                        checkBtnAnswer[i.index] = 1
                        setAnserBtn(i.index, btn_anser_four_txt.text.toString())
                        break
                    }
                }


                counterAnser++
                if (counterAnser == maxAnser) {
                    btn_check.isVisible = true
                }
                btn_anser_four.alpha = btn_alpha_answer
            }
        }


        //--------------------------------------------------------------------------

        btn_result_one.setOnClickListener {
            if (!btnCheckPosition && btn_result_one.alpha!=btn_alpha_result) {

                setBackAnswer(btn_result_one_txt.text.toString())
                checkBtnAnswer[0]=-1
                counterAnser--
                btn_result_one.alpha = btn_alpha_result
                btn_result_one_txt.text=""
            }
        }
        btn_result_two.setOnClickListener {
            if (!btnCheckPosition && btn_result_two.alpha!=btn_alpha_result) {

                setBackAnswer(btn_result_two_txt.text.toString())
                checkBtnAnswer[1]=-1
                counterAnser--
                btn_result_two.alpha = btn_alpha_result
                btn_result_two_txt.text=""
            }
        }
        btn_result_three.setOnClickListener {
            if (!btnCheckPosition && btn_result_three.alpha!=btn_alpha_result) {

                setBackAnswer(btn_result_three_txt.text.toString())
                checkBtnAnswer[2]=-1
                counterAnser--
                btn_result_three.alpha = btn_alpha_result
                btn_result_three_txt.text=""
            }
        }


        btn_check.setOnClickListener {
            if (!btnCheckPosition) {
                btnCheckPosition = true
                checkAnswerInRight(view)
                progressBar.setProgress(position+1)
            } else {
                btn_check.text="Check"
                btnCheckPosition = false
                if (position != 11) {
                    position++
                    btn_check.isVisible=false

                    btn_result_one.setBackgroundResource(R.drawable.step_lvl_btn)
                    btn_result_two.setBackgroundResource(R.drawable.step_lvl_btn)
                    btn_result_three.setBackgroundResource(R.drawable.step_lvl_btn)


                    workInTest()
                } else {
                    val bundle = Bundle()
                    bundle.putInt("mistake",(12-counterRightAnser))
                    bundle.putLong("time",startTime)
                    bundle.putInt("levels",2)
                    bundle.putInt("list_size",counterRightAnser)
                    Navigation.findNavController(view).navigate(R.id.testFinishFragment, bundle)
                }
            }
        }

    }

    fun checkAnswerInRight(view: View) {
        if (position != 11) btn_check.text = "Next"
        else btn_check.text="Finish"
        var rightAnser = 0

        if (listWordStep[position][0].split("/:")[1] == btn_result_one_txt.text.toString()) {
            btn_result_one.setBackgroundColor(Color.GREEN)
            rightAnser++
        } else {
            btn_result_one.setBackgroundColor(Color.RED)
        }
        if (listWordStep[position][1].split("/:")[1] == btn_result_two_txt.text.toString()) {
            btn_result_two.setBackgroundColor(Color.GREEN)
            rightAnser++
        } else {
            btn_result_two.setBackgroundColor(Color.RED)
        }
        if (listWordStep[position][2].split("/:")[1] == btn_result_three_txt.text.toString()) {
            btn_result_three.setBackgroundColor(Color.GREEN)
            rightAnser++
        } else {
            btn_result_three.setBackgroundColor(Color.RED)
        }

        if (rightAnser == maxAnser) counterRightAnser++

    }

    fun addWordInTest() {
        for (i in 0..11) {
            listWordStep[i].add(listWord[list_position % listWord.size])
            list_position++
            listWordStep[i].add(listWord[list_position % listWord.size])
            list_position++
            listWordStep[i].add(listWord[list_position % listWord.size])
            list_position++
            listWordStep[i].add(listWord[list_position % listWord.size])
            list_position++
        }
    }

    fun workInTest() {
        checkBtnAnswer = arrayListOf(-1, -1, -1, -1)
        counterAnser = 0

        btn_result_one.setBackgroundResource(R.drawable.step_lvl_btn_res)
        btn_result_two.setBackgroundResource(R.drawable.step_lvl_btn_res)
        btn_result_three.setBackgroundResource(R.drawable.step_lvl_btn_res)

        btn_result_one_txt.text=""
        btn_result_two_txt.text=""
        btn_result_three_txt.text=""


        btn_result_one.alpha=btn_alpha_result
        btn_result_two.alpha=btn_alpha_result
        btn_result_three.alpha=btn_alpha_result

        maxAnser = 3
        //кнопки
        word_in_one.text = listWordStep[position][0].split("/:")[0]
        word_in_two.text = listWordStep[position][1].split("/:")[0]
        word_in_three.text = listWordStep[position][2].split("/:")[0]
        var reshafl = arrayListOf<String>()
        for (j in listWordStep[position]) {
            reshafl.add(j)
        }
        reshafl.shuffle()
        btn_anser_one_txt.text = reshafl[0].split("/:")[1]
        btn_anser_two_txt.text = reshafl[1].split("/:")[1]
        btn_anser_three_txt.text = reshafl[2].split("/:")[1]
        btn_anser_four_txt.text = reshafl[3].split("/:")[1]


        btn_anser_one.alpha=1f
        btn_anser_two.alpha=1f
        btn_anser_three.alpha=1f
        btn_anser_four.alpha=1f




    }

    fun init(view: View) {
        btn_anser_one = view.findViewById(R.id.step_three_btn_ans_one)
        btn_anser_two = view.findViewById(R.id.step_three_btn_ans_two)
        btn_anser_three = view.findViewById(R.id.step_three_btn_ans_three)
        btn_anser_four = view.findViewById(R.id.step_three_btn_ans_four)

        btn_anser_one_txt = view.findViewById(R.id.step_three_btn_ans_one_txt)
        btn_anser_two_txt= view.findViewById(R.id.step_three_btn_ans_two_txt)
        btn_anser_three_txt = view.findViewById(R.id.step_three_btn_ans_three_txt)
        btn_anser_four_txt = view.findViewById(R.id.step_three_btn_ans_four_txt)



        btn_result_one = view.findViewById(R.id.step_three_btn_res_one)
        btn_result_two = view.findViewById(R.id.step_three_btn_res_two)
        btn_result_three = view.findViewById(R.id.step_three_btn_res_three)

        btn_result_one_txt = view.findViewById(R.id.step_three_btn_res_one_txt)
        btn_result_two_txt = view.findViewById(R.id.step_three_btn_res_two_txt)
        btn_result_three_txt = view.findViewById(R.id.step_three_btn_res_three_txt)

        btn_check = view.findViewById(R.id.step_three_btn_check)
        word_in_one = view.findViewById(R.id.step_three_en_one)
        word_in_two = view.findViewById(R.id.step_three_en_two)
        word_in_three = view.findViewById(R.id.step_three_en_three)
        exit = view.findViewById(R.id.step_three_exit)
        progressBar = view.findViewById(R.id.step_three_progress_bar)
        progressBar.setProgress(position)
        progressBar.max = MaxProgress


    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StepThreeFragment().apply {
            }
    }
}