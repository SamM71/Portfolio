using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SoundManager : MonoBehaviour
{
    private AudioSource[] sounds;

    private AudioSource jump;
    private AudioSource death;
    private AudioSource oneUp;
    private AudioSource invincibility;

    // Start is called before the first frame update
    void Start()
    {
        sounds = GetComponents<AudioSource>();

        jump = sounds[0];
        death = sounds[1];
        oneUp = sounds[2];
        invincibility = sounds[3];
    }


    public void PlayJump()
    {
        jump.Play();
    }

    public void PlayDeath()
    {
        death.Play();
    }

    public void PlayOneUp()
    {
        oneUp.Play();
    }

    public void PlayInvincibility()
    {
        invincibility.Play();
    }

}
