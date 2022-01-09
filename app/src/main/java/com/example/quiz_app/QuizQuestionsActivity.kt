package com.example.quiz_app

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var selectedOptionPosition: Int = 0
    private var mUserName: String? = null
    private var mCorrectAnswers: Int = 0


    private var progressbar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tv_Question: TextView? = null
    private var ivImage: ImageView? = null

    private var tv_option1: TextView? = null
    private var tv_option2: TextView? = null
    private var tv_option3: TextView? = null
    private var tv_option4: TextView? = null
    private var btnSubmit: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.User_Name)

        progressbar = findViewById(R.id.progressbar)
        tvProgress = findViewById(R.id.tv_progress)
        tv_Question = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_img)

        tv_option1 = findViewById(R.id.option_one)
        tv_option2 = findViewById(R.id.option_two)
        tv_option3 = findViewById(R.id.option_three)
        tv_option4 = findViewById(R.id.option_four)

        btnSubmit = findViewById(R.id.btn_submit)

        tv_option1?.setOnClickListener(this)
        tv_option2?.setOnClickListener(this)
        tv_option3?.setOnClickListener(this)
        tv_option4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)


       mQuestionList = Constants.getQuestions()
        setQuestion()

    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        defaultOptionsView()
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressbar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressbar?.max}"
        tv_Question?.text = question.question
        tv_option1?.text = question.optionOne
        tv_option2?.text = question.optionTwo
        tv_option3?.text = question.optionThree
        tv_option4?.text = question.optionFour

        if(mCurrentPosition == mQuestionList!!.size){
            btnSubmit?.text = "FINISH"
        }else{

            btnSubmit?.text = "SUBMIT"
        }

        progressbar?.progress = mCurrentPosition
        tvProgress?.text ="$mCurrentPosition" + "/" + progressbar?.max

    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()

        tv_option1?.let {
            options.add(0, it)
        }
        tv_option2?.let {
            options.add(1, it)
        }
        tv_option3?.let {
            options.add(2, it)
        }
        tv_option4?.let {
            options.add(3, it)
        }

        for(option in options){
           option.setTextColor(Color.parseColor("#7A8089"))
           option.typeface = Typeface.DEFAULT
           option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)

        }

    }

    fun selectedOptionView(tv:TextView, selectedOPtionNum: Int){
        defaultOptionsView()

        selectedOptionPosition = selectedOPtionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option_one ->{
                tv_option1?.let{
                    selectedOptionView(it,1)
                }
            }
            R.id.option_two ->{
                tv_option2?.let{
                    selectedOptionView(it,2)
                }
            }
            R.id.option_three ->{
            tv_option3?.let{
                selectedOptionView(it,3)
            }
        }
            R.id.option_four ->{
                tv_option4?.let{
                    selectedOptionView(it,4)
                }
            }

            R.id.btn_submit ->{
                if(selectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else->{
                            val intent = Intent(this, Result::class.java)
                            intent.putExtra(Constants.User_Name, mUserName)
                            intent.putExtra(Constants.Correct_Answers, mCorrectAnswers)
                            intent.putExtra(Constants.Total_questions,mQuestionList?.size)
                            startActivity(intent)
                            finish()

                        }
                    }
                    }
                else{
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if(question!!.correctAns != selectedOptionPosition){
                        answerView(selectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswers++
                    }
                        answerView(question.correctAns, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionList!!.size){
                        btnSubmit?.text = "FINISH"
                    }else{
                        btnSubmit?.text = "NEXT QUESTION"
                    }
                    selectedOptionPosition = 0
                }
            }
        }

    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1->{
                tv_option1?.background = ContextCompat.getDrawable(
                    this, drawableView)
            }
            2->{
                tv_option2?.background = ContextCompat.getDrawable(
                    this, drawableView)
            }
            3->{
                tv_option3?.background = ContextCompat.getDrawable(
                    this, drawableView)
            }
            4->{
                tv_option4?.background = ContextCompat.getDrawable(
                    this, drawableView)
            }
        }
    }
}