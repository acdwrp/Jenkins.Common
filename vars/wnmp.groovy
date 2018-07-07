def call()
{
    def properties = readJSON file: ConfigLocation

    echo properties.AWSBucket
}
