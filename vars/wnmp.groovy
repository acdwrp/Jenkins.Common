def call(Map config)
{
    def properties = readJSON file: ConfigLocation
    echo ABC

    echo properties.AWSBucket
}
