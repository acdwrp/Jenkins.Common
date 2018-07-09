def call()
{
    def properties = readJSON file: ConfigLocation

    def includes = properties.Artifacts.Includes.toList()

    def artifacts1 = ""

    def type = includes.getClass()

    echo "${type}"

    def sub = includes.subList(0, includes.size() -1)

    def type2 = sub.getClass()

    echo "${type2}"

    for (i = 0; i< includes.size(); i++) {
       def incl = sub[i]
    }

    echo artifacts1

    zip(glob: properties.ArtifactsToPack, zipFile: properties.ZipPackageName)
    archiveArtifacts(artifacts: properties.ZipPackageName, onlyIfSuccessful: true, fingerprint: true)
}