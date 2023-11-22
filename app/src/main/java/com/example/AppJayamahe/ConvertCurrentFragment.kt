package com.example.AppJayamahe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class ConvertCurrentFragment : Fragment() {

    private fun createCustomAdapter(list: MutableList<String>): ArrayAdapter<String> {
        return ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            list
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var _view = inflater.inflate(R.layout.fragment_convert, container, false)
        val list: MutableList<String> = ArrayList()

        list.add("US Dollar")//index 0
        list.add("Korean Won")//1
        list.add("Euro")//2
        list.add("Japanese Yen")//3
        list.add("Australian dollar")//4
        list.add("Canadian dollar")//5
        list.add("Pound Sterling")//6
        list.add("Peso")//7


        val adapter: ArrayAdapter<String> = createCustomAdapter(list)

        val spinner = _view.findViewById<Spinner>(R.id.spinner)
        val spinner3 = _view.findViewById<Spinner>(R.id.spinner3)
        spinner.adapter = adapter
        spinner3.adapter = adapter

        var item1 = ""
        var item2 = ""

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                item1 = list[position]

            }
        }

        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                item2 = list[position]
            }
        }

        val button = _view.findViewById<Button>(R.id.button)
        val editText2 = _view.findViewById<EditText>(R.id.editText2)
        val textView2 = _view.findViewById<TextView>(R.id.textView2)

        button.setOnClickListener {

            val valNum = editText2.text.toString().toDouble()

            //if the conversion is the same item then we just display the entered number
            if (item1 == item2) {
                textView2.text = valNum.toString()
            }//first else if is for the US dollar
            else if (item1 == list[0]) {
                if (item2 == list[1]) {
                    textView2.text = (valNum * 1182.79).toString()
                } else if (item2 == list[2]) {
                    textView2.text = (valNum * 0.86).toString()
                } else if (item2 == list[3]) {
                    textView2.text = (valNum * 114.3).toString()
                } else if (item2 == list[4]) {
                    textView2.text = (valNum * 1.35).toString()
                } else if (item2 == list[5]) {
                    textView2.text = (valNum * 1.24).toString()
                } else if (item2 == list[6]) {
                    textView2.text = (valNum * 0.73).toString()
                } else if (item2 == list[7]) {
                    textView2.text = (valNum * 20.34).toString()
                }
            }//conversions for the korean won
            else if (item1 == list[1]) {
                if (item2 == list[0]) {
                    textView2.text = (valNum * 0.00085).toString()
                } else if (item2 == list[2]) {
                    textView2.text = (valNum * 0.00073).toString()
                } else if (item2 == list[3]) {
                    textView2.text = (valNum * 0.097).toString()
                } else if (item2 == list[4]) {
                    textView2.text = (valNum * 0.0011).toString()
                } else if (item2 == list[5]) {
                    textView2.text = (valNum * 0.001).toString()
                } else if (item2 == list[6]) {
                    textView2.text = (valNum * 0.00061).toString()
                } else if (item2 == list[7]) {
                    textView2.text = (valNum * 0.017).toString()
                }
            }//conversions for the euro
            else if (item1 == list[2]) {
                if (item2 == list[0]) {
                    textView2.text = (valNum * 1.16).toString()
                } else if (item2 == list[1]) {
                    textView2.text = (valNum * 1371.89).toString()
                } else if (item2 == list[3]) {
                    textView2.text = (valNum * 132.61).toString()
                } else if (item2 == list[4]) {
                    textView2.text = (valNum * 1.56).toString()
                } else if (item2 == list[5]) {
                    textView2.text = (valNum * 1.43).toString()
                } else if (item2 == list[6]) {
                    textView2.text = (valNum * 0.84).toString()
                } else if (item2 == list[7]) {
                    textView2.text = (valNum * 23.61).toString()
                }
            }//conversions for the japanese yen
            else if (item1 == list[3]) {
                if (item2 == list[0]) {
                    textView2.text = (valNum * 0.0087).toString()
                } else if (item2 == list[1]) {
                    textView2.text = (valNum * 10.34).toString()
                } else if (item2 == list[2]) {
                    textView2.text = (valNum * 0.0075).toString()
                } else if (item2 == list[4]) {
                    textView2.text = (valNum * 0.012).toString()
                } else if (item2 == list[5]) {
                    textView2.text = (valNum * 0.011).toString()
                } else if (item2 == list[6]) {
                    textView2.text = (valNum * 0.0064).toString()
                } else if (item2 == list[7]) {
                    textView2.text = (valNum * 0.18).toString()
                }
            }//conversions for the australian dollar
            else if (item1 == list[4]) {
                if (item2 == list[0]) {
                    textView2.text = (valNum * 0.74).toString()
                } else if (item2 == list[1]) {
                    textView2.text = (valNum * 878.27).toString()
                } else if (item2 == list[2]) {
                    textView2.text = (valNum * 0.64).toString()
                } else if (item2 == list[3]) {
                    textView2.text = (valNum * 84.9).toString()
                } else if (item2 == list[5]) {
                    textView2.text = (valNum * 0.92).toString()
                } else if (item2 == list[6]) {
                    textView2.text = (valNum * 0.54).toString()
                } else if (item2 == list[7]) {
                    textView2.text = (valNum * 15.11).toString()
                }
            }//conversions for the canadian dollar
            else if (item1 == list[5]) {
                if (item2 == list[0]) {
                    textView2.text = (valNum * 0.81).toString()
                } else if (item2 == list[1]) {
                    textView2.text = (valNum * 956.36).toString()
                } else if (item2 == list[2]) {
                    textView2.text = (valNum * 0.70).toString()
                } else if (item2 == list[3]) {
                    textView2.text = (valNum * 92.43).toString()
                } else if (item2 == list[4]) {
                    textView2.text = (valNum * 1.09).toString()
                } else if (item2 == list[6]) {
                    textView2.text = (valNum * 0.59).toString()
                } else if (item2 == list[7]) {
                    textView2.text = (valNum * 16.45).toString()
                }
            }//conversions for the pound sterling
            else if (item1 == list[6]) {
                if (item2 == list[0]) {
                    textView2.text = (valNum * 1.38).toString()
                } else if (item2 == list[1]) {
                    textView2.text = (valNum * 1627.41).toString()
                } else if (item2 == list[2]) {
                    textView2.text = (valNum * 1.19).toString()
                } else if (item2 == list[3]) {
                    textView2.text = (valNum * 157.26).toString()
                } else if (item2 == list[4]) {
                    textView2.text = (valNum * 1.85).toString()
                } else if (item2 == list[5]) {
                    textView2.text = (valNum * 1.7).toString()
                } else if (item2 == list[7]) {
                    textView2.text = (valNum * 28.01).toString()
                }
            }//conversions for the peso
            else if (item1 == list[7]) {
                if (item2 == list[0]) {
                    textView2.text = (valNum * 0.049).toString()
                } else if (item2 == list[1]) {
                    textView2.text = (valNum * 58.13).toString()
                } else if (item2 == list[2]) {
                    textView2.text = (valNum * 0.042).toString()
                } else if (item2 == list[3]) {
                    textView2.text = (valNum * 5.62).toString()
                } else if (item2 == list[4]) {
                    textView2.text = (valNum * 0.066).toString()
                } else if (item2 == list[5]) {
                    textView2.text = (valNum * 0.061).toString()
                } else if (item2 == list[6]) {
                    textView2.text = (valNum * 0.036).toString()
                }
            }
        }

        return _view
    }

    }

