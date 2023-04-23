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
                        R.raw.bill
                    ),
                    StepWord(
                        "the Supreme Court",
                        "[sȷu:ˈprɪ:m]",
                        "Верховный Суд ",
                        R.raw.russiastep2
                    ),
                    StepWord(
                        "the Constitutional Court",
                        "[ˌkɔnstɪˈtȷu:ʃənəl  kɔːt]",
                        "Конституционный Суд",
                        R.raw.russiastep21
                    ),
                    StepWord(
                        "The Council of Federation",
                        "[ˈkaunsl]",
                        "Совет Федерации ",
                        R.raw.russiastep22
                    ),
                    StepWord(
                        "Chairman",
                        "[ˈtʃɛəmən]",
                        "председатель",
                        R.raw.russiastep23
                    ),
                    StepWord(
                        "Chamber",
                        "[ˈtʃeɪmbə] ",
                        "Палата",
                        R.raw.russiastep24
                    ),
                    StepWord(
                        "the Federal Assembly",
                        "[əˈsemblɪ]",
                        "Федеральное Собрание",
                        R.raw.russiastep25
                    ),
                    StepWord(
                        "deputy prime minister",
                        "[ˈdepȷutɪ]",
                        "вице-премьер",
                        R.raw.russiastep26
                    ),
                    StepWord(
                        "the Supreme Commander-in-Chief of the Armed Forces",
                        "-",
                        "главнокомандующий вооруженных сил ",
                        R.raw.russiastep27
                    )
                )
                2->arrayListOf<StepWord>(
                    StepWord(
                        "elect",
                        "[ɪˈlekt]",
                        "избирать, выбирать",
                        R.raw.russiastep3
                    ),
                    StepWord(
                        "exercise",
                        "['eksəsaɪz]",
                        "осуществлять",
                        R.raw.russiastep31
                    ),
                    StepWord(
                        "appoint",
                        "[ə'pɔɪnt]",
                        "назначать (на должность)",
                        R.raw.russiastep32
                    ),
                    StepWord(
                        "comprise",
                        "[kəmˈpraɪz]",
                        "включать в себя",
                        R.raw.russiastep33
                    ),
                    StepWord(
                        "occupy",
                        "[ˈɔkȷupaɪ]",
                        "занимать место",
                        R.raw.russiastep34
                    ),
                    StepWord(
                        "possess ",
                        "[pəˈzes]",
                        "обладать",
                        R.raw.russiastep35
                    ),
                    StepWord(
                        "impress ",
                        "[ɪmpˈres]",
                        "производить впечатление",
                        R.raw.russiastep36
                    ),
                    StepWord(
                        "be ranked 5th / rank 5 th",
                        "[ræŋk]",
                        "занимать 5-e место",
                        R.raw.russiastep37
                    ),
                    StepWord(
                        "compose",
                        "[kəmˈpəuz]",
                        "составлять",
                        R.raw.russiastep38
                    )
                )
                3->arrayListOf<StepWord>(
                    StepWord(
                        "surface",
                        "[ˈsə:fɪs]",
                        "поверхность",
                        R.raw.russiastep4
                    ),
                    StepWord(
                        "total area",
                        "[ˈɛərɪə]",
                        "общая площадь",
                        R.raw.russiastep41
                    ),
                    StepWord(
                        "variety",
                        "[vəˈraɪətɪ]",
                        "разнообразие",
                        R.raw.russiastep42
                    ),
                    StepWord(
                        "scenery",
                        "[ˈsɪ:nərɪ]",
                        "пейзаж",
                        R.raw.russiastep43
                    ),
                    StepWord(
                        "vegetation",
                        "[ˌvedʒɪˈteɪʃən]",
                        "растительность",
                        R.raw.russiastep44
                    ),
                    StepWord(
                        "plain",
                        "[pleɪn]",
                        "равнина",
                        R.raw.russiastep45
                    ),
                    StepWord(
                        "steppe",
                        "[step]",
                        "степь",
                        R.raw.russiastep46
                    ),
                    StepWord(
                        "tundra",
                        "[ˈtʌndrə]",
                        "тундра",
                        R.raw.russiastep47
                    ),
                    StepWord(
                        "mountain chain",
                        "[ˈmauntɪn tʃeɪn]",
                        "горная цепь",
                        R.raw.russiastep48
                    )
                )
                4->arrayListOf<StepWord>(
                    StepWord(
                        "to border on",
                        "[ˈbɔ:də]",
                        "граничить с",
                        R.raw.russiastep51
                    ),
                    StepWord(
                        "to have borders with",
                        "-",
                        "иметь границы",
                        R.raw.russiastep52
                    ),
                    StepWord(
                        "separate",
                        "['sepəreɪt]",
                        "отделять",
                        R.raw.russiastep53
                    ),
                    StepWord(
                        "span",
                        "[spæn]",
                        "охватывать",
                        R.raw.russiastep54
                    ),
                    StepWord(
                        "vast",
                        "[va:st]",
                        "обширный",
                        R.raw.russiastep55
                    ),
                    StepWord(
                        "temperate",
                        "[ˈtempərɪt]",
                        "умеренный",
                        R.raw.russiastep511
                    ),
                    StepWord(
                        "iron ore",
                        "['aɪən 'ɔ:]",
                        "железная руда",
                        R.raw.russiastep56
                    ),
                    StepWord(
                        "ferrous metal",
                        "[ˈferəs]",
                        "черный металл",
                        R.raw.russiastep57
                    ),
                    StepWord(
                        "non-ferrous  metal",
                        "-",
                        "цветной металл",
                        R.raw.russiastep58
                    ),
                    StepWord(
                        "copper",
                        "['kɔpə]",
                        "медь",
                        R.raw.russiastep59
                    ),
                    StepWord(
                        "cover",
                        "[ˈkʌvə] ",
                        "покрывать",
                        R.raw.russiastep510
                    )
                )
                5->arrayListOf<StepWord>(
                    StepWord(
                        "populous",
                        "[ˈpɔpȷuləs]",
                        "густонаселенный",
                        R.raw.russiastep6
                    ),
                    StepWord(
                        "rich in smth",
                        "-",
                        "богатый (чем-л.)",
                        R.raw.russiastep61
                    ),
                    StepWord(
                        "numerous",
                        "[ˈnȷumərəs]",
                        "многочисленный",
                        R.raw.russiastep62
                    ),
                    StepWord(
                        "vast",
                        "[va:st]",
                        "обширный",
                        R.raw.russiastep63
                    ),
                    StepWord(
                        "anthem",
                        "[ˈænθəm]",
                        "гимн",
                        R.raw.russiastep64
                    ),
                    StepWord(
                        "urban",
                        "[ˈə:bən] ",
                        "городской",
                        R.raw.russiastep65
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
                1-> arrayListOf<StepWord>(
                    StepWord(
                        "natural resources",
                        "[ˈnætʃərəl rɪˈsɔ:sɪz]",
                        "природные ресурсы",
                        R.raw.bashkortstep2
                    ),
                    StepWord(
                        "iron-ore",
                        "[aɪən  ɔ:]",
                        "железная руда",
                        R.raw.bashkortstep21
                    ),
                    StepWord(
                        "zinc",
                        "[zɪŋk]",
                        "цинк",
                        R.raw.bashkortstep22
                    ),
                    StepWord(
                        "lead",
                        "[led]",
                        "свинец",
                        R.raw.bashkortstep23
                    ),
                    StepWord(
                        "aluminium",
                        "[ˌælȷəˈmɪnɪəm]",
                        "алюминий",
                        R.raw.bashkortstep24
                    ),
                    StepWord(
                        "chromium",
                        "[ˈkrəumȷəm]",
                        "хром",
                        R.raw.bashkortstep25
                    ),
                    StepWord(
                        "brown coal",
                        "[kəul]",
                        "бурый уголь",
                        R.raw.bashkortstep26
                    ),
                    StepWord(
                        "natural gas",
                        "[ɡæs]",
                        "природный газ",
                        R.raw.bashkortstep27
                    ),
                    StepWord(
                        "manganese",
                        "[ˌmæŋɡəˈnɪ:z]",
                        "марганец",
                        R.raw.bashkortstep28
                    )
                )
                2->arrayListOf<StepWord>(
                    StepWord(
                        "sovereign",
                        "[ˈsɔvrɪn]",
                        "суверенный",
                        R.raw.bashkortstep3
                    ),
                    StepWord(
                        "entity",
                        "[ˈentɪtɪ]",
                        "субъект",
                        R.raw.bashkortstep31
                    ),
                    StepWord(
                        "claim sovereignty",
                        "[kleɪm ˈsɔvrəntɪ]",
                        "провозглашать суверенитет",
                        R.raw.bashkortstep32
                    ),
                    StepWord(
                        "multicultural",
                        "[ˌmʌltɪˈkʌltʃərəl]",
                        "многокультурный",
                        R.raw.bashkortstep33
                    ),
                    StepWord(
                        "multinational",
                        "[ˌmʌltɪˈnæʃənəl]",
                        "многонациональный",
                        R.raw.bashkortstep34
                    ),
                    StepWord(
                        "ethnic",
                        "[ˈeθnɪk]",
                        "этнический",
                        R.raw.bashkortstep35
                    ),
                    StepWord(
                        "autonomy",
                        "[ɔ:ˈtɔnəmɪ]",
                        "автономия",
                        R.raw.bashkortstep36
                    ),
                    StepWord(
                        "enable",
                        "[ɪˈneɪbl]",
                        "давать возможность или право",
                        R.raw.bashkortstep37
                    ),
                    StepWord(
                        "self-sufficient",
                        "[ˌself  səˈfɪʃənt]",
                        "самостоятельный",
                        R.raw.bashkortstep38
                    )
                )
                3->arrayListOf<StepWord>(
                    StepWord(
                        "grain",
                        "[greɪn]",
                        "зерно",
                        R.raw.bashkortstep4
                    ),
                    StepWord(
                        "sugar beet",
                        "[ˈʃuɡə bɪ:t]",
                        "сахарная свекла",
                        R.raw.bashkortstep41
                    ),
                    StepWord(
                        "sunflower seeds",
                        "[sɪ:dz]",
                        "семена подсолнечника",
                        R.raw.bashkortstep42
                    ),
                    StepWord(
                        "horse breeding",
                        "-",
                        "коневодство",
                        R.raw.bashkortstep43
                    ),
                    StepWord(
                        "bee-keeping ",
                        "-",
                        "пчеловодство",
                        R.raw.bashkortstep44
                    ),
                    StepWord(
                        "agricultural",
                        "[ˌæɡrɪˈkʌltʃərəl]",
                        "сельскохозяйственный",
                        R.raw.bashkortstep45
                    ),
                    StepWord(
                        "unique",
                        "[ȷuˈnɪ:k]",
                        "исключительный",
                        R.raw.bashkortstep46
                    ),
                    StepWord(
                        "diverse",
                        "[daɪˈvə:s]",
                        "разнообразный",
                        R.raw.bashkortstep47
                    ),
                    StepWord(
                        "healing",
                        "[ˈhɪ:lɪŋ]",
                        "целебный",
                        R.raw.bashkortstep48
                    )
                )
                4->arrayListOf<StepWord>(
                    StepWord(
                        "oil fountain",
                        "[ˈfauntɪn]",
                        "нефтяной фонтан",
                        R.raw.bashkortstep5
                    ),
                    StepWord(
                        "oil rig",
                        "-",
                        "нефтяная вышка",
                        R.raw.bashkortstep51
                    ),
                    StepWord(
                        "oil deposit",
                        "[dɪˈpɔzɪt]",
                        "нефтяное месторождение",
                        R.raw.bashkortstep52
                    ),
                    StepWord(
                        "oil-extracting region",
                        "[ɪkˈstræktɪŋ ˈrɪ:dʒən]",
                        "нефтедобывающий регион",
                        R.raw.bashkortstep53
                    ),
                    StepWord(
                        "drill a well",
                        "-",
                        "бурить скважину",
                        R.raw.bashkortstep54
                    ),
                    StepWord(
                        "extract oil",
                        "[ɪkˈstrækt]",
                        "добывать нефть",
                        R.raw.bashkortstep55
                    ),
                    StepWord(
                        "refining",
                        "[rɪˈfaɪnɪŋ]",
                        "переработка",
                        R.raw.bashkortstep56
                    ),
                    StepWord(
                        "burst",
                        "[bɜːst]",
                        "прорываться наружу",
                        R.raw.bashkortstep57
                    )
                )
                5->arrayListOf<StepWord>(
                    StepWord(
                        "impressive",
                        "[ɪmˈpresɪv]",
                        "впечатляющий",
                        R.raw.bashkortstep6
                    ),
                    StepWord(
                        "record",
                        "[ˈrekɔ:d]",
                        "результат, итог, запись, отчет",
                        R.raw.bashkortstep61
                    ),
                    StepWord(
                        "considerable",
                        "[kən'sɪd(ə)rəbl]",
                        "значительный",
                        R.raw.bashkortstep62
                    ),
                    StepWord(
                        "exceed",
                        "[ɪkˈsɪ:d]",
                        "превышать",
                        R.raw.bashkortstep63
                    ),
                    StepWord(
                        "inhabit",
                        "[ɪnˈhæbɪt]",
                        "населять",
                        R.raw.bashkortstep64
                    ),
                    StepWord(
                        "experience growth",
                        "[ɪksˈpɪərɪəns grəuθ]",
                        "переживать рост",
                        R.raw.bashkortstep65
                    ),
                    StepWord(
                        "refer to smth",
                        "[rɪˈfə:]",
                        "ссылаться на что-либо",
                        R.raw.bashkortstep66
                    )
                )
                6->arrayListOf<StepWord>(
                    StepWord(
                        "wealth",
                        "[welθ]",
                        "богатство",
                        R.raw.bashkortstep7
                    ),
                    StepWord(
                        "boost",
                        "boost",
                        "ускорять",
                        R.raw.bashkortstep71
                    ),
                    StepWord(
                        "branch of industry",
                        "[brɑ:ntʃ]",
                        "отрасль промышленности",
                        R.raw.bashkortstep72
                    ),
                    StepWord(
                        "capital asset",
                        "[ˈæset]",
                        "основной  капитал",
                        R.raw.bashkortstep73
                    ),
                    StepWord(
                        "capacity",
                        "[kəˈpæsətɪ]",
                        "способность",
                        R.raw.bashkortstep74
                    ),
                    StepWord(
                        "draw finance",
                        "[drɔ: 'faɪnæns]",
                        "привлекать финансы",
                        R.raw.bashkortstep75
                    ),
                    StepWord(
                        "steep growth",
                        "[stɪ:p grəuθ]",
                        "резкий рост",
                        R.raw.bashkortstep76
                    )
                )
                7->arrayListOf<StepWord>(
                    StepWord(
                        "assist with smth",
                        "[əˈsɪst]",
                        "содействовать",
                        R.raw.bashkortstep8
                    ),
                    StepWord(
                        "timber industry",
                        "-",
                        "лесная промышленность",
                        R.raw.bashkortstep81
                    ),
                    StepWord(
                        "woodworking industry",
                        "-",
                        "деревообрабатывающая промышленность",
                        R.raw.bashkortstep82
                    ),
                    StepWord(
                        "discover",
                        "-",
                        "обнаруживать",
                        R.raw.bashkortstep83
                    ),
                    StepWord(
                        "introduction",
                        "[ˌɪntrəˈdʌkʃən]",
                        "внедрение",
                        R.raw.bashkortstep84
                    ),
                    StepWord(
                        "gross output",
                        "-",
                        "валовое производство",
                        R.raw.bashkortstep85
                    ),
                    StepWord(
                        "process",
                        "[ˈprəuses]",
                        "обрабатывать",
                        R.raw.bashkortstep86
                    )
                )
                8->arrayListOf<StepWord>(
                    StepWord(
                        "picturesque",
                        "[ˌpɪktʃəˈresk]",
                        "живописный ",
                        R.raw.bashkortstep9
                    ),
                    StepWord(
                        "resort",
                        "[rɪˈzɔ:t]",
                        "курорт",
                        R.raw.bashkortstep91
                    ),
                    StepWord(
                        "pride oneself on smth",
                        "-",
                        "гордиться чем-либо",
                        R.raw.bashkortstep92
                    ),
                    StepWord(
                        "liberty",
                        "[ˈlɪbətɪ]",
                        "свобода",
                        R.raw.bashkortstep93
                    ),
                    StepWord(
                        "acclaim",
                        "[əˈkleɪm]",
                        "получать признание",
                        R.raw.bashkortstep96
                    ),
                    StepWord(
                        "conviction",
                        "[kənˈvɪkʃən]",
                        "убеждение",
                        R.raw.bashkortstep94
                    ),
                    StepWord(
                        "renowned for smth.",
                        "[rɪˈnaund]",
                        "прославленный чем-либо",
                        R.raw.bashkortstep95
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
                1->arrayListOf<StepWord>(
                    StepWord(
                        "carbon",
                        "['kɑːbən]",
                        "углерод",
                        R.raw.hydrocabstep2
                    ),
                    StepWord(
                        "hydrogen",
                        "['haɪdrəʤən]",
                        "водород",
                        R.raw.hydrocabstep21
                    ),
                    StepWord(
                        "hydrocarbon",
                        "[ˌhaɪdrəu'kɑːbən]",
                        "углеводород",
                        R.raw.hydrocabstep22
                    ),
                    StepWord(
                        "pore",
                        "[pɔː]",
                        "пора",
                        R.raw.hydrocabstep23
                    ),
                    StepWord(
                        "fracture",
                        "['frækʧə]",
                        "разлом",
                        R.raw.hydrocabstep24
                    ),
                    StepWord(
                        "rock",
                        "-",
                        "горная порода",
                        R.raw.hydrocabstep25
                    ),
                    StepWord(
                        "reservoir",
                        "['rezəvwɑː]",
                        "пласт-коллектор",
                        R.raw.hydrocabstep26
                    ),
                    StepWord(
                        "fluid",
                        "['fluːɪd]",
                        "текучая среда",
                        R.raw.hydrocabstep27
                    )
                )
                2->arrayListOf<StepWord>(
                    StepWord(
                        "jet fuel",
                        "[ʤet fjuːəl]",
                        "реактивное топливо",
                        R.raw.hydrocabstep3
                    ),
                    StepWord(
                        "fuel oil",
                        "-",
                        "мазут",
                        R.raw.hydrocabstep31
                    ),
                    StepWord(
                        "pipeline",
                        "['paɪplaɪn]",
                        "трубопровод",
                        R.raw.hydrocabstep32
                    ),
                    StepWord(
                        "refinery",
                        "[rɪ'faɪnərɪ]",
                        "нефтеперерабатывающий завод (НПЗ)",
                        R.raw.hydrocabstep33
                    ),
                    StepWord(
                        "distribution",
                        "[ˌdɪstrɪ'bjuːʃən]",
                        "распределение",
                        R.raw.hydrocabstep34
                    ),
                    StepWord(
                        "gasoline",
                        "['gæsəliːn]",
                        "бензин",
                        R.raw.hydrocabstep35
                    ),
                    StepWord(
                        "gasoline station",
                        "-",
                        "автомобильная заправочная станция (АЗС)",
                        R.raw.hydrocabstep36
                    ),
                    StepWord(
                        "commodity",
                        "[kə'mɔdətɪ]",
                        "товар",
                        R.raw.hydrocabstep37
                    ),
                    StepWord(
                        "process",
                        "['prəuses]",
                        "обрабатывать",
                        R.raw.hydrocabstep38
                    )
                )
                3->arrayListOf<StepWord>(
                    StepWord(
                        "surface",
                        "['sɜːfɪs]",
                        "поверхность",
                        R.raw.hydrocabstep4
                    ),
                    StepWord(
                        "float",
                        "[fləut]",
                        "плавать на поверхности",
                        R.raw.hydrocabstep41
                    ),
                    StepWord(
                        "accumulate",
                        "[ə'kjuːmjəleɪt]",
                        "накапливать(ся)",
                        R.raw.hydrocabstep42
                    ),
                    StepWord(
                        "matter",
                        "['mætə]",
                        "вещество",
                        R.raw.hydrocabstep43
                    ),
                    StepWord(
                        "beneath",
                        "[bɪ'niːθ]",
                        "внизу",
                        R.raw.hydrocabstep44
                    ),
                    StepWord(
                        "layer",
                        "['leɪə]",
                        "слой",
                        R.raw.hydrocabstep45
                    ),
                    StepWord(
                        "pressure",
                        "['preʃə]",
                        "давление",
                        R.raw.hydrocabstep46
                    ),
                    StepWord(
                        "liquid",
                        "['lɪkwɪd]",
                        "жидкость",
                        R.raw.hydrocabstep47
                    ),
                    StepWord(
                        "through",
                        "[θruː]",
                        "через",
                        R.raw.hydrocabstep48
                    ),
                    StepWord(
                        "throughout",
                        "[θru'aut]",
                        "везде",
                        R.raw.hydrocabstep49
                    )
                )
                4->arrayListOf<StepWord>(
                    StepWord(
                        "value",
                        "['væljuː]",
                        "ценность; важность",
                        R.raw.hydrocabstep5
                    ),
                    StepWord(
                        "constituent",
                        "[kən'stɪtjuənt]",
                        "составная часть",
                        R.raw.hydrocabstep51
                    ),
                    StepWord(
                        "vaporize",
                        "['veɪpəraɪz]",
                        "испарять(ся)",
                        R.raw.hydrocabstep52
                    ),
                    StepWord(
                        "stream",
                        "[striːm]",
                        "поток",
                        R.raw.hydrocabstep53
                    ),
                    StepWord(
                        "pure",
                        "[pjuə]",
                        "беспримесный",
                        R.raw.hydrocabstep54
                    ),
                    StepWord(
                        "manufacturing",
                        "[ˌmænjə'fækʧərɪŋ]",
                        "производство",
                        R.raw.hydrocabstep55
                    ),
                    StepWord(
                        "various",
                        "['vɛərɪəs]",
                        "различный",
                        R.raw.hydrocabstep56
                    ),
                    StepWord(
                        "sophisticated",
                        "[sə'fɪstɪkeɪtɪd]",
                        "сложно устроенный",
                        R.raw.hydrocabstep56
                    ),
                    StepWord(
                        "facility",
                        "[fə'sɪlətɪ]",
                        "сооружение",
                        R.raw.hydrocabstep57
                    )
                )
                5->arrayListOf<StepWord>(
                    StepWord(
                        "hardly",
                        "['hɑːdlɪ]",
                        "едва",
                        R.raw.hydrocabstep6
                    ),
                    StepWord(
                        "unit",
                        "['juːnɪt]",
                        "единица (измерения)",
                        R.raw.hydrocabstep61
                    ),
                    StepWord(
                        "remain",
                        "[rɪ'meɪn]",
                        "оставаться ",
                        R.raw.hydrocabstep62
                    ),
                    StepWord(
                        "barrel, bbl.",
                        "['bærəl]",
                        "баррель (159 л)",
                        R.raw.hydrocabstep63
                    ),
                    StepWord(
                        "measure",
                        "['meʒə]",
                        "единица измерения/измерять",
                        R.raw.hydrocabstep64
                    ),
                    StepWord(
                        "obtain",
                        "[əb'teɪn]",
                        "получать",
                        R.raw.hydrocabstep65
                    ),
                    StepWord(
                        "truck",
                        "[trʌk]",
                        "грузовой автомобиль",
                        R.raw.hydrocabstep66
                    ),
                    StepWord(
                        "failure",
                        "['feɪljə]",
                        "авария",
                        R.raw.hydrocabstep67
                    )
                )
                6->arrayListOf<StepWord>(
                    StepWord(
                        "accompany",
                        "[ə'kʌmpənɪ]",
                        "сопровождать",
                        R.raw.hydrocabstep7
                    ),
                    StepWord(
                        "accomplish",
                        "[ə'kɔmplɪʃ]",
                        "совершать, выполнять; достигать; завершать",
                        R.raw.hydrocabstep71
                    ),
                    StepWord(
                        "accept",
                        "[ək'sept]",
                        "допускать",
                        R.raw.hydrocabstep72
                    ),
                    StepWord(
                        "comprise",
                        "[kəm'praɪz]",
                        "заключать в себе",
                        R.raw.hydrocabstep73
                    ),
                    StepWord(
                        "virtually",
                        "['vɜːʧuəlɪ]",
                        "фактически",
                        R.raw.hydrocabstep74
                    ),
                    StepWord(
                        "significant",
                        "[sɪg'nɪfɪkənt]",
                        "значительный",
                        R.raw.hydrocabstep75
                    ),
                    StepWord(
                        "primarily",
                        "[praɪ'merəlɪ]",
                        "в основном",
                        R.raw.hydrocabstep76
                    ),
                    StepWord(
                        "except",
                        "[ɪk'sept]",
                        "за исключением",
                        R.raw.hydrocabstep77
                    ),
                    StepWord(
                        "either … or",
                        "['aɪðə   ɔː]",
                        "или … или",
                        R.raw.hydrocabstep78
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