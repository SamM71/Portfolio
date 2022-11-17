using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class Score : MonoBehaviour
{
    public static int score = 0;
    public Text scoreText;
    //public int time;
    //GameObject timer;

    // Start is called before the first frame update
    void Start()
    {
        scoreText = GetComponent<Text>();
    }

    // Update is called once per frame
    void Update()
    {
        scoreText.text = "Score: " + score.ToString();
    }

    /*
    void OnSceneLoaded(Scene scene, LoadSceneMode mode)
    {
       timer = GameObject.FindWithTag("LinearTimer");
    }
    */
}
