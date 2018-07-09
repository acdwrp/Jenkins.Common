def call(def environment)
{
    def properties = readJSON file: ConfigLocation

    echo properties.AWSBucket
}
