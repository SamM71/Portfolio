using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class AchievementManager : MonoBehaviour
{
    public GameObject achNote;
    public AudioSource achSound;
    public bool achActive = false;
    public GameObject achTitle;
    public GameObject achDesc;

    //public GameObject ach01Image;
    public static int ach01Count;
    public int ach01Trigger = 5;
    public int ach01Code;


    // Update is called once per frame
    void Update()
    {
        ach01Code = PlayerPrefs.GetInt("Ach01");
        if (ach01Count == ach01Trigger && ach01Code != 12345)
        {
            StartCoroutine(Trigger01Ach());
        }
    }

    IEnumerator Trigger01Ach()
    {
        achActive = true;
        ach01Code = 12345;
        PlayerPrefs.SetInt("Ach01", ach01Code);
        //achSound.Play();
        //ach01Image.SetActive(true);
        achTitle.GetComponent<Text>().text = "Achievement Unlocked";
        achDesc.GetComponent<Text>().text = "Collect 5 Abilities";
        achNote.SetActive(true);
        yield return new WaitForSeconds(7);
        //Resetting UI
        achNote.SetActive(false);
        //ach01Image.SetActive(false);
        achTitle.GetComponent<Text>().text = "";
        achDesc.GetComponent<Text>().text = "";
        achActive = false;
    }



    private Queue<Achievement> achievements = new Queue<Achievement>();

    public void NotifyAchievementComplete(string ID)
    {
        achievements.Enqueue(new Achievement(ID));
    }

    // Start is called before the first frame update
    void Start()
    {
        PlayerPrefs.SetInt("Ach01", 0);
    }

    private void UnlockAchievement(Achievement achievement)
    {
        //Collect powerup?
        Debug.Log("Achievement unlocked:" + achievement.ID);
    }

    private IEnumerator AchievementQueueCheck()
    {
        for(; ;)
        {
            if (achievements.Count > 0) UnlockAchievement(achievements.Dequeue());
            yield return new WaitForSeconds(5f);
        }
    }


}
