using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class HighScore : MonoBehaviour
{
    public static int score = 0;
    public Text scoreText;

    // Start is called before the first frame update
    void Start()
    {
        scoreText = GetComponent<Text>();
        
    }

    private void Update()
    {
        scoreText.text = "High Score: " + PlayerPrefs.GetInt("HighScore").ToString();
    }
}
