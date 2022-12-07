# Katana Project

## Modules

# Katana-CLI

Below are the CLI command features available as of now.

* **katana-cli compile**

  `katana-cli compile --name 105-cube6-katana`

  Creates a merged output of the SQL's. Performs a 2 level compilation
  * Mustache Compilation for the imports & Sources.
  * Spark SQL parser compilation for the syntax errors.

* **katana-cli deploy**

  `katana-cli deploy --name 105-cube6-katana`

  Creates a package to deploy into the Dolphin Scheduler Cluster
  * This will take the output of the compile command and add it under the deploy folder of the project.
  * This will also take the base config.yml and place it under the deploy folder.
  * Any changes made to config.yml has to re-compile and deploy.

* **katana-cli create-project**

  `katana-cli create-project --name 105-cube6-katana`

  Creates project folder structure for the project with the sql and configuration files.
  * Developer/Analyst has to create a module under sql folder and add in the sql with the config.yml
  * Each module should have a mandatory main.sql which will be wrapped up into final output.
  * Each module should have a mandatory config.yml to mention the module name and the dependent sources.

* **katana-cli schedule-to-dolphin**

  `katana-cli schedule-to-dolphin --name 105-cube6-katana`

  * This command takes the configuration of the Dolphin Cluster from the <project>/config.yml
  * This internally calls the Dolphin Scheduler API's.
  * This command uploads the entire folder under the deploy folder of the project into the Resources section.
  * This also creates a workflow based on the configuration and dependencies mentioned in the config.yml.
  * It creates a workflow per project.


# Katana-spark-lib