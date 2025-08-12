# Replay Study – Automatic Uncovering of Hidden Behaviors From Input Validation in Mobile Apps

We replayed the paper [Automatic Uncovering of Hidden Behaviors From Input Validation in Mobile Apps](https://github.com/OSUSecLab/InputScope).
The paper presents a static analysis that uncovers hidden behavior in Android apps through input validation logic. While the original analysis, published in 2020, examined 150,000 apps, we re-execute their pipeline on 10,331 apps collected in 2023 and 2024, to study how hidden behavior in Android apps has evolved over the past five years.
Overall, we observed a decline in the prevalence of hidden behavior. Nevertheless, we also identifid backdoors similar to those originally reported, indicating that such techniques remain present.

## Folder Structure
* [Gradle version of InputScope](./InputScopeGrade/)
* [Evaluation Script](./evaluation/)



## How to cite:

```
@inproceedings{2025:replay_inputscope,
    title     = {{Replay – Automatic Uncovering of Hidden Behaviors From Input Validation in Mobile Apps}},
    author    = {Schmidt, David and Schrittwieser, Sebastian },
    booktitle = {Proceedings of the Workshop on Research on offensive and defensive techniques in the context of Man At The End (MATE) attacks},
    year      = {2025},
}
```



## Contacts
* David Schmidt:
    * email: d.schmidt@univie.ac.at
    * Bluesky: [@dschm1dt](https://bsky.app/profile/dschm1dt.bsky.social)
* Sebastian Schrittwieser
    * email: sebastian.schrittwieser@univie.ac.at


### Dataset and Analysis Artifacts
We share the app dataset and all artifacts on request. Please get in touch with us and send us your public key.