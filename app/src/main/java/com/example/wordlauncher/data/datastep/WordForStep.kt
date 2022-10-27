package com.example.wordlauncher.data.datastep

import com.example.wordlauncher.R
import com.example.wordlauncher.handlers.step.StepItem
import com.example.wordlauncher.handlers.step.StepWord

class WordForStep {
    companion object {
        fun WordStepList(them_position: Int, step_position: Int): ArrayList<StepWord> {
            return when (them_position) {
                0 -> wordThemOne(step_position)
                1 -> wordThemTwo(step_position)
                2 -> wordThemThree(step_position)
                else -> {
                    wordThemOne(step_position)
                }
            }

        }

        private fun wordThemOne(position: Int): ArrayList<StepWord> {
            return when (position) {
                0 -> arrayListOf<StepWord>(
                    StepWord(
                        "judicial",
                        "[dʒu:ˈdɪʃəl]",
                        "судебный",
                        R.raw.judicial
                    ),
                    StepWord(
                        "executive",
                        "[ɪɡˈzekȷutɪv]",
                        "исполнительный",
                        R.raw.executive
                    ),
                    StepWord(
                        "legislative",
                        "[ˈledʒɪslətɪv]",
                        "законодательный",
                        R.raw.legislative
                    ),
                    StepWord(
                        "semi-presidential",
                        "[ˌprezɪˈdenʃəl]",
                        "полупрезидентский",
                        R.raw.semi_presidential
                    ),
                    StepWord(
                        "structured",
                        "[ˈstrʌktʃəd]",
                        "структурированный",
                        R.raw.structured
                    ),
                    StepWord(
                        "multi-party",
                        "[ˈmʌltɪ]",
                        "многопартийный",
                        R.raw.multi_party
                    ),
                    StepWord(
                        "government",
                        "[ˈɡʌvnmənt]",
                        "правительство/управление",
                        R.raw.government
                    ),
                    StepWord(
                        "head",
                        "[hed]",
                        "глава",
                        R.raw.head
                    ),
                    StepWord(
                        "representative democracy",
                        "[dɪˈmɔkrəsɪ]",
                        "представительная демократия",
                        R.raw.representative_democracy
                    ),
                    StepWord(
                        "branch  of power",
                        "[brɑ:ntʃ]",
                        "ветвь власти",
                        R.raw.branch_of_power
                    )
                )
                1->arrayListOf<StepWord>(
                    StepWord(
                        "bill",
                        "bill",
                        "законопроект",
                        1
                    ),
                    StepWord(
                        "the Supreme Court",
                        "[sȷu:ˈprɪ:m]",
                        "Верховный Суд ",
                        1
                    ),
                    StepWord(
                        "the Constitutional Court",
                        "[ˌkɔnstɪˈtȷu:ʃənəl  kɔːt]",
                        "Конституционный Суд",
                        1
                    ),
                    StepWord(
                        "The Council of Federation",
                        "[ˈkaunsl]",
                        "Совет Федерации ",
                        1
                    ),
                    StepWord(
                        "Chairman",
                        "[ˈtʃɛəmən]",
                        "председатель",
                        1
                    ),
                    StepWord(
                        "Chamber",
                        "[ˈtʃeɪmbə] ",
                        "Палата",
                        1
                    ),
                    StepWord(
                        "the Federal Assembly",
                        "[əˈsemblɪ]",
                        "Федеральное Собрание",
                        1
                    ),
                    StepWord(
                        "deputy prime minister",
                        "[ˈdepȷutɪ]",
                        "вице-премьер",
                        1
                    ),
                    StepWord(
                        "the Supreme Commander-in-Chief of the Armed Forces",
                        "-",
                        "главнокомандующий вооруженных сил ",
                        1
                    )
                )
                else -> {
                    arrayListOf<StepWord>(
                        StepWord(
                            "Russian Step 1",
                            "Российская Федерация",
                            "R.drawable.russia",
                            1
                        ),
                        StepWord(
                            "Russian Step 2",
                            "башкортостан",
                            "R.drawable.bashkortostan",
                            1
                        ),
                        StepWord(
                            "Russian Step 3",
                            "Введение в нефтяную промышленность",
                            "R.drawable.russia",
                            1
                        )
                    )
                }
            }
        }

        private fun wordThemTwo(position: Int): ArrayList<StepWord> {
            return when (position) {
                0 -> arrayListOf<StepWord>(
                    StepWord(
                        "fox",
                        "[fɔks] ",
                        "лиса",
                        R.raw.fox
                    ),
                    StepWord(
                        "marten",
                        "[ˈmɑ:tɪn]",
                        "куница",
                        R.raw.marten
                    ),
                    StepWord(
                        "beaver",
                        "[ˈbɪ:və]",
                        "бобер",
                        R.raw.beaver
                    ),
                    StepWord(
                        "elk",
                        "[elk]",
                        "лось ",
                        R.raw.elk
                    ),
                    StepWord(
                        "roe",
                        "[rəu]",
                        "косуля",
                        R.raw.roe
                    ),
                    StepWord(
                        "bear",
                        "[beə]",
                        "медведь",
                        R.raw.bear
                    ),
                    StepWord(
                        "lynx",
                        "[lɪŋks]",
                        "рысь",
                        R.raw.lynx
                    ),
                    StepWord(
                        "wolf",
                        "[wulf]",
                        "волк",
                        R.raw.wolf
                    ),
                    StepWord(
                        "badger",
                        "[ˈbædʒə]",
                        "барсук",
                        R.raw.badger
                    ),
                    StepWord(
                        "species",
                        "[ˈspɪ:ʃɪ:z]",
                        "вид",
                        R.raw.species
                    )
                )
                else -> {
                    arrayListOf<StepWord>(
                        StepWord(
                            "Russian Step 1",
                            "Российская Федерация",
                            "R.drawable.russia",
                            1
                        ),
                        StepWord(
                            "Russian Step 2",
                            "башкортостан",
                            "R.drawable.bashkortostan",
                            1
                        ),
                        StepWord(
                            "Russian Step 3",
                            "Введение в нефтяную промышленность",
                            "R.drawable.russia",
                            1
                        )
                    )
                }
            }
        }

        private fun wordThemThree(position: Int): ArrayList<StepWord> {
            return when (position) {
                0 -> arrayListOf<StepWord>(
                    StepWord(
                        "exploration",
                        "[ˌeksplə'reɪʃən]",
                        "разведка",
                        R.raw.exploration
                    ),
                    StepWord(
                        "production",
                        "[prə'dʌkʃən]",
                        "добыча",
                        R.raw.production
                    ),
                    StepWord(
                        "well",
                        "-",
                        "скважина",
                        R.raw.well
                    ),
                    StepWord(
                        "natural gas",
                        "['næʧərəl]",
                        "природный газ",
                        R.raw.natural_gas
                    ),
                    StepWord(
                        "crude oil",
                        "[kruːd]",
                        "сырая нефть",
                        R.raw.crude_oil
                    ),
                    StepWord(
                        "pump",
                        "[pʌmp]",
                        " насос/качать",
                        R.raw.pump
                    ),
                    StepWord(
                        "inject",
                        "[ɪn'ʤekt]",
                        "нагнетать",
                        R.raw.inject
                    ),
                    StepWord(
                        "mixture",
                        "['mɪksʧə]",
                        "смесь",
                        R.raw.mixture
                    ),
                    StepWord(
                        "compound",
                        "['kɔmpaund]",
                        "соединение",
                        R.raw.compound
                    )
                )
                else -> {
                    arrayListOf<StepWord>(
                        StepWord(
                            "Russian Step 1",
                            "Российская Федерация",
                            "R.drawable.russia",
                            1
                        ),
                        StepWord(
                            "Russian Step 2",
                            "башкортостан",
                            "R.drawable.bashkortostan",
                            1
                        ),
                        StepWord(
                            "Russian Step 3",
                            "Введение в нефтяную промышленность",
                            "R.drawable.russia",
                            1
                        )
                    )
                }
            }
        }

    }
}