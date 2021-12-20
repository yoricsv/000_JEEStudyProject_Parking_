## [002_JMvnWebapp_][DescPrj]

### <p align=center>[Project][DescPrj] | [Building][AutoBld] | [Installing][AutoInst] <br/> [Web-app][WebBld] | [Modularity][Module] | [Dependency][DepMng]</p>

<!--
* [Project description][DescPrj]
* [Project build automation][AutoBld]
* [Project setup automation][AutoInst]
* [Web application building][WebBld]
* [Project modularity][Module]
* [Dependency management][DepMng]
-->

[DescPrj]:  README.md
[AutoBld]:  res/read/Maven_BuildAutomation.md
[AutoInst]: res/read/Maven_SetupAutomation.md
[WebBld]:   res/read/Maven_WebApplication.md
[Module]:   res/read/Maven_ModularityProject.md
[DepMng]:   res/read/Maven_DependencyManagement.md

---
<!-- ---------------------------------- * Navigation * ---------------------------------- -->

# <p align=center><i>Project name:</i> "<b>Parking</b>"</p>

An interface required for parking operators in the event of a system failure.
For example:

* The license plate is dirty and can't be identified by the scanner.
* To manage free parking.
* To check payment, etc.

## Stages of creating a multi-module project

### The steps

1. Set the Environment variables: JAVA_HOME and M2_HOME (see: [001_JMaven_][jMvn])
2. Run the IntelliJ IDEA
3. Create `New project`

### IntelliJ IDEA start window

![NewProject][ideaNewPro]

4. Choose `Maven` -> Click button `[Next]`<br/>

### New project configuration window

![NewMavenProject][mvnNewPro]

5. Choose the **Location** (Exp.: `#_JavaEnterprise_`)
6. Type **Name** (Exp.: `002_JMvnWebapp_`)
7. Unroll the `Artifact Coordinates` *(click on it)*
8. Type GroupId: *domainL1*.*domainL2*.*domainL3* (Exp.: `pro.yoric.it`)
9. Type ArtifactId: *projectName* (Exp.: `Parking`)
10. Type Version: *versionNumber* (Exp.: `4.0.23.7`)
11. Click button `[Finish]`<br/>

### New project configuration window

![NewMavenCoordinateProject][ideaCfgWnd]

12. After cteation, need modify `pom.xml` file, add package type **pom**

```xml
<packaging>pom</packaging>
```

### To create additional modules

1. To create a new module do next: *File* -> *Project structure*<br/>

### Create New module

![Create modules step 1][crMod1]

2. Go to the `Modules` in content menu
3. Use sign `+` in the left of top side.
4. Choose `New module`<br/>

### Project structure configuration window

![Create modules step 2][crMod2]

5. Use the unrolling menu `Parent` if you wanna create a child from the other parant
6. Enter a name of the module (Exp.: `controller`) and click `Finish` button

### New module configuration window

![Create modules step 3][crMod3]

> ***NOTE:*** The module name will be automatically added to the ArtifactId.<br/>
*Repeat these steps for each additional module*

### After all the manipulations, we get something like this into the main pom.xml file

```xml
<modules>
    <module>ui</module>
    <module>controller</module>
    <module>data</module>
</modules>
```

### New project structure

![New project structure][newProStr]

### To make sure you did everything right, build the project

There are two Different ways

* **First** *(by Maven)*:
  1. Click the `Maven` label in the upper right corner
  2. In the content menu, look for the package label that is labeled as *(root)* next to them (for example: **Parking** *(root)*).
  3. Unroll it and the `Lifecycle` label to see more
  4. In the `Lifecycle` list, hold down the `[ctrl]` button and click `clean` and `install`
  5. Final, click on the ***Run*** button *(see screenshot)*:

### Build project via Maven

![Build project via Maven][bldMvn]

* **Second** *(by Terminal)*:
  1. Click the `Terminal` label in the bottom
  2. Enter the next command: `mvn clean install` -> `Enter`
  3. If you see the Error: *mvn : The term 'mvn' is not recognized ...* it means you haven't set the JAVA_HOME and M2_HOME environment variables *(see screenshot)*:

### Build project via Terminal *(Error)*

![Build via Terminal error][bldTerm1]

  4. Set the Enviromental variables to fix it (more information [here][jMvn])
  5. After setting, enter the following command to make sure you did everything correctly:

### Check Java and Maven operating

```bash
java -version
mvn --version
```

### Build project via Terminal *(Fix Error)*

![Build via Terminal fix error][bldTerm2]

  6. Final, try again to enter the next command: `mvn clean install` -> `Enter`:

### Build project via Terminal  *(Build Success)*

![Build via Terminal success][bldTerm3]

<!--
* [001_JMaven_][jMvn]
* ![NewProject][ideaNewPro]
* ![NewMavenProject][mvnNewPro]
* ![NewMavenCoordinateProject][ideaCfgWnd]
* ![Create modules step 1][crMod1]
* ![Create modules step 2][crMod2]
* ![Create modules step 3][crMod3]
* ![New project structure][newProStr]
* ![Build via Maven][bldMvn]
* ![Build via Terminal][bldTerm1]
* ![Build via Terminal][bldTerm2]
* ![Build via Terminal][bldTerm3]
-->

[jMvn]:       https://github.com/yoricsv/001_JMaven_/blob/master/res/read/Maven_Configuration.md
[ideaNewPro]: res/img/IdeaNewProject.png
[mvnNewPro]:  res/img/ConfigNewProject.png
[ideaCfgWnd]: res/img/ConfigNewProgectCoord.png
[crMod1]:     res/img/CreateModules.png
[crMod2]:     res/img/CreateModulesS2.png
[crMod3]:     res/img/CreateModulesS3.png
[newProStr]:  res/img/POMProjectStructure.png
[bldMvn]:     res/img/CompilePOMProject.png
[bldTerm1]:   res/img/ConpilePOMProjectViaIdeaTerminal_Error.png
[bldTerm2]:   res/img/ConpilePOMProjectViaIdeaTerminal_ErrorFix.png
[bldTerm3]:   res/img/ConpilePOMProjectViaIdeaTerminal_BuildSuccess.png

---