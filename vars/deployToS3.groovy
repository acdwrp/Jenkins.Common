def call(Map config)
{
    echo config.file

    withAWS(credentials: 'AWSCredentials', region: 'eu-west-1') {
          timeout(time: 3, unit: 'MINUTES') {
            retry(count: 5) {
              s3Upload(file: ZipPackageName, bucket: AWSBucket, path: "Test${WorkspaceName}/${ZipPackageName}")
            }

          }

        }
}