package com.example.wordlauncher.ui.step.five

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.example.wordlauncher.R
import com.example.wordlauncher.StepActivity
import com.example.wordlauncher.checkBackState
import com.example.wordlauncher.data.datastep.WordForStep


class StepFiveFragment : Fragment() {

    lateinit var btn_anser_one: Button
    lateinit var btn_anser_two: Button
    lateinit var btn_anser_three: Button
    lateinit var btn_anser_four: Button
    lateinit var btn_anser_five: Button
    lateinit var btn_anser_six: Button
    lateinit var btn_anser_seven: Button
    lateinit var btn_result_one: Button
    lateinit var btn_result_two: Button
    lateinit var btn_result_three: Button
    lateinit var btn_result_four: Button
    lateinit var btn_result_five: Button
    lateinit var btn_check: Button
    lateinit var word_in_one: TextView
    lateinit var word_in_two: TextView
    lateinit var word_in_three: TextView
    lateinit var word_in_four: TextView
    lateinit var word_in_five: TextView
    lateinit var exit: ImageView

    private var CurrentProgress = 0
    private var MaxProgress = 9
    lateinit var progressBar: ProgressBar
    var startTime: Long = 0
    var list_position = 0
    var position = 0
    var maxAnser = 3
    var counterAnser = 0
    var counterRightAnser = 0
    var btnCheckPosition = false

    var checkBtnAnswer: ArrayList<Int> = arrayListOf(-1, -1, -1, -1, -1)
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
        arrayListOf<String>()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_step_five, container, false)
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
                btn_result_one.isVisible = true
                btn_result_one.text = str
            }
            1 -> {
                btn_result_two.isVisible = true
                btn_result_two.text = str
            }
            2 -> {
                btn_result_three.isVisible = true
                btn_result_three.text = str
            }
            3 -> {
                btn_result_four.isVisible = true
                btn_result_four.text = str
            }
            4 -> {
                btn_result_five.isVisible = true
                btn_result_five.text = str
            }
        }
    }

    fun setBackAnswer(str: String) {
        when (str) {
            btn_anser_one.text.toString() -> {
                btn_anser_one.isVisible = true
            }
            btn_anser_two.text.toString() -> {
                btn_anser_two.isVisible = true
            }
            btn_anser_three.text.toString() -> {
                btn_anser_three.isVisible = true
            }
            btn_anser_four.text.toString() -> {
                btn_anser_four.isVisible = true
            }
            btn_anser_five.text.toString() -> {
                btn_anser_five.isVisible = true
            }
            btn_anser_six.text.toString() -> {
                btn_anser_six.isVisible = true
            }
            btn_anser_seven.text.toString() -> {
                btn_anser_seven.isVisible = true
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
            if (counterAnser < maxAnser) {

                for (i in checkBtnAnswer.withIndex()) {
                    if (checkBtnAnswer[i.index] == -1 && i.index < maxAnser) {
                        checkBtnAnswer[i.index] = 1
                        setAnserBtn(i.index, btn_anser_one.text.toString())
                        break
                    }
                }


                counterAnser++
                if (counterAnser == maxAnser) {
                    btn_check.isVisible = true
                }
                btn_anser_one.isVisible = false
            }

        }
        btn_anser_two.setOnClickListener {
            if (counterAnser < maxAnser) {

                for (i in checkBtnAnswer.withIndex()) {
                    if (checkBtnAnswer[i.index] == -1 && i.index < maxAnser) {
                        checkBtnAnswer[i.index] = 1
                        setAnserBtn(i.index, btn_anser_two.text.toString())
                        break
                    }
                }


                counterAnser++
                if (counterAnser == maxAnser) {
                    btn_check.isVisible = true
                }
                btn_anser_two.isVisible = false
            }
        }
        btn_anser_three.setOnClickListener {
            if (counterAnser < maxAnser) {

                for (i in checkBtnAnswer.withIndex()) {
                    if (checkBtnAnswer[i.index] == -1 && i.index < maxAnser) {
                        checkBtnAnswer[i.index] = 1
                        setAnserBtn(i.index, btn_anser_three.text.toString())
                        break
                    }
                }


                counterAnser++
                if (counterAnser == maxAnser) {
                    btn_check.isVisible = true
                }
                btn_anser_three.isVisible = false
            }
        }
        btn_anser_four.setOnClickListener {
            if (counterAnser < maxAnser) {

                for (i in checkBtnAnswer.withIndex()) {
                    if (checkBtnAnswer[i.index] == -1 && i.index < maxAnser) {
                        checkBtnAnswer[i.index] = 1
                        setAnserBtn(i.index, btn_anser_four.text.toString())
                        break
                    }
                }


                counterAnser++
                if (counterAnser == maxAnser) {
                    btn_check.isVisible = true
                }
                btn_anser_four.isVisible = false
            }
        }
        btn_anser_five.setOnClickListener {
            if (counterAnser < maxAnser) {

                for (i in checkBtnAnswer.withIndex()) {
                    if (checkBtnAnswer[i.index] == -1 && i.index < maxAnser) {
                        checkBtnAnswer[i.index] = 1
                        setAnserBtn(i.index, btn_anser_five.text.toString())
                        break
                    }
                }


                counterAnser++
                if (counterAnser == maxAnser) {
                    btn_check.isVisible = true
                }
                btn_anser_five.isVisible = false
            }
        }
        btn_anser_six.setOnClickListener {
            if (counterAnser < maxAnser) {

                for (i in checkBtnAnswer.withIndex()) {
                    if (checkBtnAnswer[i.index] == -1 && i.index < maxAnser) {
                        checkBtnAnswer[i.index] = 1
                        setAnserBtn(i.index, btn_anser_six.text.toString())
                        break
                    }
                }


                counterAnser++
                if (counterAnser == maxAnser) {
                    btn_check.isVisible = true
                }
                btn_anser_six.isVisible = false
            }
        }
        btn_anser_seven.setOnClickListener {
            if (counterAnser < maxAnser) {

                for (i in checkBtnAnswer.withIndex()) {
                    if (checkBtnAnswer[i.index] == -1 && i.index < maxAnser) {
                        checkBtnAnswer[i.index] = 1
                        setAnserBtn(i.index, btn_anser_seven.text.toString())
                        break
                    }
                }


                counterAnser++
                if (counterAnser == maxAnser) {
                    btn_check.isVisible = true
                }
                btn_anser_seven.isVisible = false
            }
        }

        //--------------------------------------------------------------------------

        btn_result_one.setOnClickListener {
            setBackAnswer(btn_result_one.text.toString())
            checkBtnAnswer[0] = -1
            counterAnser--
            btn_result_one.isVisible = false
        }
        btn_result_two.setOnClickListener {
            setBackAnswer(btn_result_two.text.toString())
            checkBtnAnswer[1] = -1
            counterAnser--
            btn_result_two.isVisible = false
        }
        btn_result_three.setOnClickListener {
            setBackAnswer(btn_result_three.text.toString())
            checkBtnAnswer[2] = -1
            counterAnser--
            btn_result_three.isVisible = false
        }
        btn_result_four.setOnClickListener {
            checkBtnAnswer[3] = -1
            setBackAnswer(btn_result_four.text.toString())
            counterAnser--
            btn_result_four.isVisible = false
        }

        btn_result_five.setOnClickListener {
            checkBtnAnswer[3] = -1
            setBackAnswer(btn_result_five.text.toString())
            counterAnser--
            btn_result_five.isVisible = false
        }

        btn_check.setOnClickListener {
            if (!btnCheckPosition) {
                btnCheckPosition = true
                checkAnswerInRight(view)
                progressBar.setProgress(position + 1)
            } else {
                btn_check.text = "Check"
                btnCheckPosition = false
                if (position != MaxProgress-1) {
                    position++
                    btn_check.isVisible = false

                    btn_result_one.setBackgroundColor(resources.getColor(R.color.color_step_answer_button))
                    btn_result_two.setBackgroundColor(resources.getColor(R.color.color_step_answer_button))
                    btn_result_three.setBackgroundColor(resources.getColor(R.color.color_step_answer_button))
                    btn_result_four.setBackgroundColor(resources.getColor(R.color.color_step_answer_button))
                    btn_result_five.setBackgroundColor(resources.getColor(R.color.color_step_answer_button))


                    workInTest()
                } else {
                    val bundle = Bundle()
                    bundle.putInt("mistake", (12 - counterRightAnser))
                    bundle.putLong("time", startTime)
                    bundle.putInt("levels", 3)
                    bundle.putInt("list_size", counterRightAnser)
                    Navigation.findNavController(view).navigate(R.id.testFinishFragment, bundle)
                }
            }
        }

    }

    fun checkAnswerInRight(view: View) {
        if (position != MaxProgress-1) btn_check.text = "Next"
        else btn_check.text="Finish"
        var rightAnser = 0
        when (maxAnser) {
            3 -> {
                if (listWordStep[position][0].split("/:")[1] == btn_result_one.text.toString()) {
                    btn_result_one.setBackgroundColor(Color.GREEN)
                    rightAnser++
                } else {
                    btn_result_one.setBackgroundColor(Color.RED)
                }
                if (listWordStep[position][1].split("/:")[1] == btn_result_two.text.toString()) {
                    btn_result_two.setBackgroundColor(Color.GREEN)
                    rightAnser++
                } else {
                    btn_result_two.setBackgroundColor(Color.RED)
                }
                if (listWordStep[position][2].split("/:")[1] == btn_result_three.text.toString()) {
                    btn_result_three.setBackgroundColor(Color.GREEN)
                    rightAnser++
                } else {
                    btn_result_three.setBackgroundColor(Color.RED)
                }

            }
            4 -> {
                if (listWordStep[position][0].split("/:")[1] == btn_result_one.text.toString()) {
                    btn_result_one.setBackgroundColor(Color.GREEN)
                    rightAnser++
                } else {
                    btn_result_one.setBackgroundColor(Color.RED)
                }
                if (listWordStep[position][1].split("/:")[1] == btn_result_two.text.toString()) {
                    btn_result_two.setBackgroundColor(Color.GREEN)
                    rightAnser++
                } else {
                    btn_result_two.setBackgroundColor(Color.RED)
                }
                if (listWordStep[position][2].split("/:")[1] == btn_result_three.text.toString()) {
                    btn_result_three.setBackgroundColor(Color.GREEN)
                    rightAnser++
                } else {
                    btn_result_three.setBackgroundColor(Color.RED)
                }
                if (listWordStep[position][3].split("/:")[1] == btn_result_four.text.toString()) {
                    btn_result_four.setBackgroundColor(Color.GREEN)
                    rightAnser++
                } else {
                    btn_result_four.setBackgroundColor(Color.RED)
                }
            }
            5 -> {
                if (listWordStep[position][0].split("/:")[1] == btn_result_one.text.toString()) {
                    btn_result_one.setBackgroundColor(Color.GREEN)
                    rightAnser++
                } else {
                    btn_result_one.setBackgroundColor(Color.RED)
                }
                if (listWordStep[position][1].split("/:")[1] == btn_result_two.text.toString()) {
                    btn_result_two.setBackgroundColor(Color.GREEN)
                    rightAnser++
                } else {
                    btn_result_two.setBackgroundColor(Color.RED)
                }
                if (listWordStep[position][2].split("/:")[1] == btn_result_three.text.toString()) {
                    btn_result_three.setBackgroundColor(Color.GREEN)
                    rightAnser++
                } else {
                    btn_result_three.setBackgroundColor(Color.RED)
                }
                if (listWordStep[position][3].split("/:")[1] == btn_result_four.text.toString()) {
                    btn_result_four.setBackgroundColor(Color.GREEN)
                    rightAnser++
                } else {
                    btn_result_four.setBackgroundColor(Color.RED)
                }
                if (listWordStep[position][4].split("/:")[1] == btn_result_five.text.toString()) {
                    btn_result_five.setBackgroundColor(Color.GREEN)
                    rightAnser++
                } else {
                    btn_result_five.setBackgroundColor(Color.RED)
                }
            }
        }

        if (rightAnser == maxAnser) counterRightAnser++

    }

    fun workInTest() {
        checkBtnAnswer = arrayListOf(-1, -1, -1, -1, -1)
        counterAnser = 0

        btn_result_one.isVisible = false
        btn_result_two.isVisible = false
        btn_result_three.isVisible = false
        btn_result_four.isVisible = false
        btn_result_five.isVisible = false
        if (position < 3) {
            //кнопки
            word_in_one.text = listWordStep[position][0].split("/:")[0]
            word_in_two.text = listWordStep[position][1].split("/:")[0]
            word_in_three.text = listWordStep[position][2].split("/:")[0]

            var reshafl = arrayListOf<String>()
            for (j in listWordStep[position]) {
                reshafl.add(j)
            }
            reshafl.shuffle()

            btn_anser_one.text = reshafl[0].split("/:")[1]
            btn_anser_two.text = reshafl[1].split("/:")[1]
            btn_anser_seven.isVisible = true
            btn_anser_seven.text = reshafl[2].split("/:")[1]


            btn_anser_one.isVisible = true
            btn_anser_two.isVisible = true
            btn_anser_seven.isVisible = true
        } else if (position < 6) {
            maxAnser = 4
            //кнопки
            word_in_one.text = listWordStep[position][0].split("/:")[0]
            word_in_two.text = listWordStep[position][1].split("/:")[0]
            word_in_three.text = listWordStep[position][2].split("/:")[0]
            word_in_four.text = listWordStep[position][3].split("/:")[0]
            word_in_four.isVisible = true

            var reshafl = arrayListOf<String>()
            for (j in listWordStep[position]) {
                reshafl.add(j)
            }
            reshafl.shuffle()

            btn_anser_seven.text = ""

            btn_anser_one.text = reshafl[0].split("/:")[1]
            btn_anser_two.text = reshafl[1].split("/:")[1]
            btn_anser_three.isVisible = true
            btn_anser_three.text = reshafl[2].split("/:")[1]
            btn_anser_four.isVisible = true
            btn_anser_four.text = reshafl[3].split("/:")[1]


            btn_anser_one.isVisible = true
            btn_anser_two.isVisible = true
            btn_anser_three.isVisible = true
            btn_anser_four.isVisible = true
        } else if (position < 9) {
            maxAnser = 5
            //кнопки
            word_in_one.text = listWordStep[position][0].split("/:")[0]
            word_in_two.text = listWordStep[position][1].split("/:")[0]
            word_in_three.text = listWordStep[position][2].split("/:")[0]
            word_in_four.text = listWordStep[position][3].split("/:")[0]
            word_in_five.text = listWordStep[position][4].split("/:")[0]
            word_in_four.isVisible = true
            word_in_five.isVisible = true
            var reshafl = arrayListOf<String>()
            for (j in listWordStep[position]) {
                reshafl.add(j)
            }
            reshafl.shuffle()

            btn_anser_seven.text = ""

            btn_anser_one.text = reshafl[0].split("/:")[1]
            btn_anser_two.text = reshafl[1].split("/:")[1]
            btn_anser_three.isVisible = true
            btn_anser_three.text = reshafl[2].split("/:")[1]
            btn_anser_four.isVisible = true
            btn_anser_four.text = reshafl[3].split("/:")[1]
            btn_anser_five.isVisible = true
            btn_anser_five.text = reshafl[4].split("/:")[1]
            btn_anser_six.isVisible = true
            btn_anser_six.text = reshafl[5].split("/:")[1]

            btn_anser_one.isVisible = true
            btn_anser_two.isVisible = true
            btn_anser_three.isVisible = true
            btn_anser_four.isVisible = true
            btn_anser_five.isVisible = true
            btn_anser_six.isVisible = true
        }

    }

    fun addWordInTest() {
        for (i in 0..8) {
            if (i < 3) {
                listWordStep[i].add(listWord[list_position % listWord.size])
                list_position++
                listWordStep[i].add(listWord[list_position % listWord.size])
                list_position++
                listWordStep[i].add(listWord[list_position % listWord.size])
                list_position++

            } else if (i < 6) {
                listWordStep[i].add(listWord[list_position % listWord.size])
                list_position++
                listWordStep[i].add(listWord[list_position % listWord.size])
                list_position++
                listWordStep[i].add(listWord[list_position % listWord.size])
                list_position++
                listWordStep[i].add(listWord[list_position % listWord.size])
                list_position++

            } else {
                listWordStep[i].add(listWord[list_position % listWord.size])
                list_position++
                listWordStep[i].add(listWord[list_position % listWord.size])
                list_position++
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
    }

    fun init(view: View) {
        btn_anser_one = view.findViewById(R.id.step_five_btn_ans_one)
        btn_anser_two = view.findViewById(R.id.step_five_btn_ans_two)
        btn_anser_three = view.findViewById(R.id.step_five_btn_ans_three)
        btn_anser_four = view.findViewById(R.id.step_five_btn_ans_four)
        btn_anser_five = view.findViewById(R.id.step_five_btn_ans_five)
        btn_anser_six = view.findViewById(R.id.step_five_ans_six)
        btn_anser_seven = view.findViewById(R.id.step_five_ans_seven)
        btn_result_one = view.findViewById(R.id.step_five_btn_res_one)
        btn_result_two = view.findViewById(R.id.step_five_btn_res_two)
        btn_result_three = view.findViewById(R.id.step_five_btn_res_three)
        btn_result_four = view.findViewById(R.id.step_five_btn_res_four)
        btn_result_five = view.findViewById(R.id.step_five_btn_res_five)
        btn_check = view.findViewById(R.id.step_five_btn_check)
        word_in_one = view.findViewById(R.id.step_five_en_one)
        word_in_two = view.findViewById(R.id.step_five_en_two)
        word_in_three = view.findViewById(R.id.step_five_en_three)
        word_in_four = view.findViewById(R.id.step_five_en_four)
        word_in_five = view.findViewById(R.id.step_five_en_five)
        exit = view.findViewById(R.id.step_five_exit)
        progressBar = view.findViewById(R.id.step_five_progress_bar)
        progressBar.setProgress(position)
        progressBar.max = MaxProgress


    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StepFiveFragment().apply {

            }
    }
}