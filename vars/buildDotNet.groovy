def call()
{
    def properties = readJSON file: ConfigLocation

    bat "nuget restore ${properties.SolutionName}"
    bat "\"${tool 'MSBuild'}\" ${properties.SolutionName} /p:Configuration=Release /p:Platform=\"Any CPU\" /p:ProductVersion=1.0.0.${BUILD_NUMBER}"
}