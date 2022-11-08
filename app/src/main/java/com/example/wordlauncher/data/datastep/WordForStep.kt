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
                2->arrayListOf<StepWord>(
                    StepWord(
                        "elect",
                        "[ɪˈlekt]",
                        "избирать, выбирать",
                        1
                    ),
                    StepWord(
                        "exercise",
                        "['eksəsaɪz]",
                        "осуществлять",
                        1
                    ),
                    StepWord(
                        "appoint",
                        "[ə'pɔɪnt]",
                        "назначать (на должность)",
                        1
                    ),
                    StepWord(
                        "comprise",
                        "[kəmˈpraɪz]",
                        "включать в себя",
                        1
                    ),
                    StepWord(
                        "occupy",
                        "[ˈɔkȷupaɪ]",
                        "занимать место",
                        1
                    ),
                    StepWord(
                        "possess ",
                        "[pəˈzes]",
                        "обладать",
                        1
                    ),
                    StepWord(
                        "impress ",
                        "[ɪmpˈres]",
                        "производить впечатление",
                        1
                    ),
                    StepWord(
                        "be ranked 5th / rank 5 th",
                        "[ræŋk]",
                        "занимать 5-e место",
                        1
                    ),
                    StepWord(
                        "compose",
                        "[kəmˈpəuz]",
                        "составлять",
                        1
                    )
                )
                3->arrayListOf<StepWord>(
                    StepWord(
                        "surface",
                        "[ˈsə:fɪs]",
                        "поверхность",
                        1
                    ),
                    StepWord(
                        "total area",
                        "[ˈɛərɪə]",
                        "общая площадь",
                        1
                    ),
                    StepWord(
                        "variety",
                        "[vəˈraɪətɪ]",
                        "разнообразие",
                        1
                    ),
                    StepWord(
                        "scenery",
                        "[ˈsɪ:nərɪ]",
                        "пейзаж",
                        1
                    ),
                    StepWord(
                        "vegetation",
                        "[ˌvedʒɪˈteɪʃən]",
                        "растительность",
                        1
                    ),
                    StepWord(
                        "plain",
                        "[pleɪn]",
                        "равнина",
                        1
                    ),
                    StepWord(
                        "steppe",
                        "[step]",
                        "степь",
                        1
                    ),
                    StepWord(
                        "tundra",
                        "[ˈtʌndrə]",
                        "тундра",
                        1
                    ),
                    StepWord(
                        "mountain chain",
                        "[ˈmauntɪn tʃeɪn]",
                        "горная цепь",
                        1
                    )
                )
                4->arrayListOf<StepWord>(
                    StepWord(
                        "to border on",
                        "[ˈbɔ:də]",
                        "граничить с",
                        1
                    ),
                    StepWord(
                        "to have borders with",
                        "-",
                        "иметь границы",
                        1
                    ),
                    StepWord(
                        "separate",
                        "['sepəreɪt]",
                        "отделять",
                        1
                    ),
                    StepWord(
                        "span",
                        "[spæn]",
                        "охватывать",
                        1
                    ),
                    StepWord(
                        "vast",
                        "[va:st]",
                        "обширный",
                        1
                    ),
                    StepWord(
                        "temperate",
                        "[ˈtempərɪt]",
                        "умеренный",
                        1
                    ),
                    StepWord(
                        "iron ore",
                        "['aɪən 'ɔ:]",
                        "железная руда",
                        1
                    ),
                    StepWord(
                        "ferrous metal",
                        "[ˈferəs]",
                        "черный металл",
                        1
                    ),
                    StepWord(
                        "non-ferrous  metal",
                        "-",
                        "цветной металл",
                        1
                    ),
                    StepWord(
                        "copper",
                        "['kɔpə]",
                        "медь",
                        1
                    ),
                    StepWord(
                        "",
                        "",
                        "",
                        1
                    )
                )
                5->arrayListOf<StepWord>(
                    StepWord(
                        "populous",
                        "[ˈpɔpȷuləs]",
                        "густонаселенный",
                        1
                    ),
                    StepWord(
                        "rich in smth",
                        "-",
                        "богатый (чем-л.)",
                        1
                    ),
                    StepWord(
                        "numerous",
                        "[ˈnȷumərəs]",
                        "многочисленный",
                        1
                    ),
                    StepWord(
                        "vast",
                        "[va:st]",
                        "обширный",
                        1
                    ),
                    StepWord(
                        "anthem",
                        "[ˈænθəm]",
                        "гимн",
                        1
                    ),
                    StepWord(
                        "urban",
                        "[ˈə:bən] ",
                        "городской",
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
                1-> arrayListOf<StepWord>(
                    StepWord(
                        "natural resources",
                        "[ˈnætʃərəl rɪˈsɔ:sɪz]",
                        "природные ресурсы",
                        1
                    ),
                    StepWord(
                        "iron-ore",
                        "[aɪən  ɔ:]",
                        "железная руда",
                        1
                    ),
                    StepWord(
                        "zinc",
                        "[zɪŋk]",
                        "цинк",
                        1
                    ),
                    StepWord(
                        "lead",
                        "[led]",
                        "свинец",
                        1
                    ),
                    StepWord(
                        "aluminium",
                        "[ˌælȷəˈmɪnɪəm]",
                        "алюминий",
                        1
                    ),
                    StepWord(
                        "chromium",
                        "[ˈkrəumȷəm]",
                        "хром",
                        1
                    ),
                    StepWord(
                        "brown coal",
                        "[kəul]",
                        "бурый уголь",
                        1
                    ),
                    StepWord(
                        "natural gas",
                        "[ɡæs]",
                        "природный газ",
                        1
                    ),
                    StepWord(
                        "manganese",
                        "[ˌmæŋɡəˈnɪ:z]",
                        "марганец",
                        1
                    )
                )
                2->arrayListOf<StepWord>(
                    StepWord(
                        "sovereign",
                        "[ˈsɔvrɪn]",
                        "суверенный",
                        1
                    ),
                    StepWord(
                        "entity",
                        "[ˈentɪtɪ]",
                        "субъект",
                        1
                    ),
                    StepWord(
                        "claim sovereignty",
                        "[kleɪm ˈsɔvrəntɪ]",
                        "провозглашать суверенитет",
                        1
                    ),
                    StepWord(
                        "multicultural",
                        "[ˌmʌltɪˈkʌltʃərəl]",
                        "многокультурный",
                        1
                    ),
                    StepWord(
                        "multinational",
                        "[ˌmʌltɪˈnæʃənəl]",
                        "многонациональный",
                        1
                    ),
                    StepWord(
                        "ethnic",
                        "[ˈeθnɪk]",
                        "этнический",
                        1
                    ),
                    StepWord(
                        "autonomy",
                        "[ɔ:ˈtɔnəmɪ]",
                        "автономия",
                        1
                    ),
                    StepWord(
                        "enable",
                        "[ɪˈneɪbl]",
                        "давать возможность или право",
                        1
                    ),
                    StepWord(
                        "self-sufficient",
                        "[ˌself  səˈfɪʃənt]",
                        "самостоятельный",
                        1
                    )
                )
                3->arrayListOf<StepWord>(
                    StepWord(
                        "grain",
                        "[greɪn]",
                        "зерно",
                        1
                    ),
                    StepWord(
                        "sugar beet",
                        "[ˈʃuɡə bɪ:t]",
                        "сахарная свекла",
                        1
                    ),
                    StepWord(
                        "sunflower seeds",
                        "[sɪ:dz]",
                        "семена подсолнечника",
                        1
                    ),
                    StepWord(
                        "horse breeding",
                        "-",
                        "коневодство",
                        1
                    ),
                    StepWord(
                        "bee-keeping ",
                        "-",
                        "пчеловодство",
                        1
                    ),
                    StepWord(
                        "agricultural",
                        "[ˌæɡrɪˈkʌltʃərəl]",
                        "сельскохозяйственный",
                        1
                    ),
                    StepWord(
                        "unique",
                        "[ȷuˈnɪ:k]",
                        "исключительный",
                        1
                    ),
                    StepWord(
                        "diverse",
                        "[daɪˈvə:s]",
                        "разнообразный",
                        1
                    ),
                    StepWord(
                        "healing",
                        "[ˈhɪ:lɪŋ]",
                        "целебный",
                        1
                    )
                )
                4->arrayListOf<StepWord>(
                    StepWord(
                        "oil fountain",
                        "[ˈfauntɪn]",
                        "нефтяной фонтан",
                        1
                    ),
                    StepWord(
                        "oil rig",
                        "-",
                        "нефтяная вышка",
                        1
                    ),
                    StepWord(
                        "oil deposit",
                        "[dɪˈpɔzɪt]",
                        "нефтяное месторождение",
                        1
                    ),
                    StepWord(
                        "oil-extracting region",
                        "[ɪkˈstræktɪŋ ˈrɪ:dʒən]",
                        "нефтедобывающий регион",
                        1
                    ),
                    StepWord(
                        "drill a well",
                        "-",
                        "бурить скважину",
                        1
                    ),
                    StepWord(
                        "extract oil",
                        "[ɪkˈstrækt]",
                        "добывать нефть",
                        1
                    ),
                    StepWord(
                        "refining",
                        "[rɪˈfaɪnɪŋ]",
                        "переработка",
                        1
                    ),
                    StepWord(
                        "burst",
                        "[bɜːst]",
                        "прорываться наружу",
                        1
                    )
                )
                5->arrayListOf<StepWord>(
                    StepWord(
                        "impressive",
                        "[ɪmˈpresɪv]",
                        "впечатляющий",
                        1
                    ),
                    StepWord(
                        "record",
                        "[ˈrekɔ:d]",
                        "результат, итог, запись, отчет",
                        1
                    ),
                    StepWord(
                        "considerable",
                        "[kən'sɪd(ə)rəbl]",
                        "значительный",
                        1
                    ),
                    StepWord(
                        "exceed",
                        "[ɪkˈsɪ:d]",
                        "превышать",
                        1
                    ),
                    StepWord(
                        "inhabit",
                        "[ɪnˈhæbɪt]",
                        "населять",
                        1
                    ),
                    StepWord(
                        "experience growth",
                        "[ɪksˈpɪərɪəns grəuθ]",
                        "переживать рост",
                        1
                    ),
                    StepWord(
                        "refer to smth",
                        "[rɪˈfə:]",
                        "ссылаться на что-либо",
                        1
                    )
                )
                6->arrayListOf<StepWord>(
                    StepWord(
                        "wealth",
                        "[welθ]",
                        "богатство",
                        1
                    ),
                    StepWord(
                        "boost",
                        "boost",
                        "ускорять",
                        1
                    ),
                    StepWord(
                        "branch of industry",
                        "[brɑ:ntʃ]",
                        "отрасль промышленности",
                        1
                    ),
                    StepWord(
                        "capital asset",
                        "[ˈæset]",
                        "основной  капитал",
                        1
                    ),
                    StepWord(
                        "capacity",
                        "[kəˈpæsətɪ]",
                        "способность",
                        1
                    ),
                    StepWord(
                        "draw finance",
                        "[drɔ: 'faɪnæns]",
                        "привлекать финансы",
                        1
                    ),
                    StepWord(
                        "steep growth",
                        "[stɪ:p grəuθ]",
                        "резкий рост",
                        1
                    )
                )
                7->arrayListOf<StepWord>(
                    StepWord(
                        "assist with smth",
                        "[əˈsɪst]",
                        "содействовать",
                        1
                    ),
                    StepWord(
                        "timber industry",
                        "-",
                        "лесная промышленность",
                        1
                    ),
                    StepWord(
                        "woodworking industry",
                        "-",
                        "деревообрабатывающая промышленность",
                        1
                    ),
                    StepWord(
                        "discover",
                        "-",
                        "обнаруживать",
                        1
                    ),
                    StepWord(
                        "introduction",
                        "[ˌɪntrəˈdʌkʃən]",
                        "внедрение",
                        1
                    ),
                    StepWord(
                        "gross output",
                        "-",
                        "валовое производство",
                        1
                    ),
                    StepWord(
                        "process",
                        "[ˈprəuses]",
                        "обрабатывать",
                        1
                    )
                )
                8->arrayListOf<StepWord>(
                    StepWord(
                        "picturesque",
                        "[ˌpɪktʃəˈresk]",
                        "живописный ",
                        1
                    ),
                    StepWord(
                        "resort",
                        "[rɪˈzɔ:t]",
                        "курорт",
                        1
                    ),
                    StepWord(
                        "pride oneself on smth",
                        "-",
                        "гордиться чем-либо",
                        1
                    ),
                    StepWord(
                        "liberty",
                        "[ˈlɪbətɪ]",
                        "свобода",
                        1
                    ),
                    StepWord(
                        "acclaim",
                        "[əˈkleɪm]",
                        "получать признание",
                        1
                    ),
                    StepWord(
                        "conviction",
                        "[kənˈvɪkʃən]",
                        "убеждение",
                        1
                    ),
                    StepWord(
                        "renowned for smth.",
                        "[rɪˈnaund]",
                        "прославленный чем-либо",
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
                        1
                    ),
                    StepWord(
                        "hydrogen",
                        "['haɪdrəʤən]",
                        "водород",
                        1
                    ),
                    StepWord(
                        "hydrocarbon",
                        "[ˌhaɪdrəu'kɑːbən]",
                        "углеводород",
                        1
                    ),
                    StepWord(
                        "pore",
                        "[pɔː]",
                        "пора",
                        1
                    ),
                    StepWord(
                        "fracture",
                        "['frækʧə]",
                        "разлом",
                        1
                    ),
                    StepWord(
                        "rock",
                        "-",
                        "горная порода",
                        1
                    ),
                    StepWord(
                        "reservoir",
                        "['rezəvwɑː]",
                        "пласт-коллектор",
                        1
                    ),
                    StepWord(
                        "fluid",
                        "['fluːɪd]",
                        "текучая среда",
                        1
                    )
                )
                2->arrayListOf<StepWord>(
                    StepWord(
                        "jet fuel",
                        "[ʤet fjuːəl]",
                        "реактивное топливо",
                        1
                    ),
                    StepWord(
                        "fuel oil",
                        "-",
                        "мазут",
                        1
                    ),
                    StepWord(
                        "pipeline",
                        "['paɪplaɪn]",
                        "трубопровод",
                        1
                    ),
                    StepWord(
                        "refinery",
                        "[rɪ'faɪnərɪ]",
                        "нефтеперерабатывающий завод (НПЗ)",
                        1
                    ),
                    StepWord(
                        "distribution",
                        "[ˌdɪstrɪ'bjuːʃən]",
                        "распределение",
                        1
                    ),
                    StepWord(
                        "gasoline",
                        "['gæsəliːn]",
                        "бензин",
                        1
                    ),
                    StepWord(
                        "gasoline station",
                        "-",
                        "автомобильная заправочная станция (АЗС)",
                        1
                    ),
                    StepWord(
                        "commodity",
                        "[kə'mɔdətɪ]",
                        "товар",
                        1
                    ),
                    StepWord(
                        "process",
                        "['prəuses]",
                        "обрабатывать",
                        1
                    )
                )
                3->arrayListOf<StepWord>(
                    StepWord(
                        "surface",
                        "['sɜːfɪs]",
                        "поверхность",
                        1
                    ),
                    StepWord(
                        "float",
                        "[fləut]",
                        "плавать на поверхности",
                        1
                    ),
                    StepWord(
                        "accumulate",
                        "[ə'kjuːmjəleɪt]",
                        "накапливать(ся)",
                        1
                    ),
                    StepWord(
                        "matter",
                        "['mætə]",
                        "вещество",
                        1
                    ),
                    StepWord(
                        "beneath",
                        "[bɪ'niːθ]",
                        "внизу",
                        1
                    ),
                    StepWord(
                        "layer",
                        "['leɪə]",
                        "слой",
                        1
                    ),
                    StepWord(
                        "pressure",
                        "['preʃə]",
                        "давление",
                        1
                    ),
                    StepWord(
                        "liquid",
                        "['lɪkwɪd]",
                        "жидкость",
                        1
                    ),
                    StepWord(
                        "through",
                        "[θruː]",
                        "через",
                        1
                    ),
                    StepWord(
                        "throughout",
                        "[θru'aut]",
                        "везде",
                        1
                    )
                )
                4->arrayListOf<StepWord>(
                    StepWord(
                        "value",
                        "['væljuː]",
                        "ценность; важность",
                        1
                    ),
                    StepWord(
                        "constituent",
                        "[kən'stɪtjuənt]",
                        "составная часть",
                        1
                    ),
                    StepWord(
                        "vaporize",
                        "['veɪpəraɪz]",
                        "испарять(ся)",
                        1
                    ),
                    StepWord(
                        "stream",
                        "[striːm]",
                        "поток",
                        1
                    ),
                    StepWord(
                        "pure",
                        "[pjuə]",
                        "беспримесный",
                        1
                    ),
                    StepWord(
                        "manufacturing",
                        "[ˌmænjə'fækʧərɪŋ]",
                        "производство",
                        1
                    ),
                    StepWord(
                        "various",
                        "['vɛərɪəs]",
                        "различный",
                        1
                    ),
                    StepWord(
                        "sophisticated",
                        "[sə'fɪstɪkeɪtɪd]",
                        "сложно устроенный",
                        1
                    ),
                    StepWord(
                        "facility",
                        "[fə'sɪlətɪ]",
                        "сооружение",
                        1
                    )
                )
                5->arrayListOf<StepWord>(
                    StepWord(
                        "hardly",
                        "['hɑːdlɪ]",
                        "едва",
                        1
                    ),
                    StepWord(
                        "unit",
                        "['juːnɪt]",
                        "единица (измерения)",
                        1
                    ),
                    StepWord(
                        "remain",
                        "[rɪ'meɪn]",
                        "оставаться ",
                        1
                    ),
                    StepWord(
                        "barrel, bbl.",
                        "['bærəl]",
                        "баррель (159 л)",
                        1
                    ),
                    StepWord(
                        "measure",
                        "['meʒə]",
                        "единица измерения/измерять",
                        1
                    ),
                    StepWord(
                        "obtain",
                        "[əb'teɪn]",
                        "получать",
                        1
                    ),
                    StepWord(
                        "truck",
                        "[trʌk]",
                        "грузовой автомобиль",
                        1
                    ),
                    StepWord(
                        "failure",
                        "['feɪljə]",
                        "авария",
                        1
                    )
                )
                6->arrayListOf<StepWord>(
                    StepWord(
                        "accompany",
                        "[ə'kʌmpənɪ]",
                        "сопровождать",
                        1
                    ),
                    StepWord(
                        "accomplish",
                        "[ə'kɔmplɪʃ]",
                        "совершать, выполнять; достигать; завершать",
                        1
                    ),
                    StepWord(
                        "accept",
                        "[ək'sept]",
                        "допускать",
                        1
                    ),
                    StepWord(
                        "comprise",
                        "[kəm'praɪz]",
                        "заключать в себе",
                        1
                    ),
                    StepWord(
                        "virtually",
                        "['vɜːʧuəlɪ]",
                        "фактически",
                        1
                    ),
                    StepWord(
                        "significant",
                        "[sɪg'nɪfɪkənt]",
                        "значительный",
                        1
                    ),
                    StepWord(
                        "primarily",
                        "[praɪ'merəlɪ]",
                        "в основном",
                        1
                    ),
                    StepWord(
                        "except",
                        "[ɪk'sept]",
                        "за исключением",
                        1
                    ),
                    StepWord(
                        "either … or",
                        "['aɪðə   ɔː]",
                        "или … или",
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

    }
}