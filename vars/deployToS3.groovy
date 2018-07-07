def call(Map config)
{
    echo config.file

    echo DeploymentProperties.AWSBucket

    withAWS(credentials: DeploymentProperties.AWSCredentials, region: DeploymentProperties.AWSRegion) {
          timeout(time: 3, unit: 'MINUTES') {
            retry(count: 5) {
              s3Upload(file: DeploymentProperties.ZipPackageName, bucket: DeploymentProperties.AWSBucket, path: "${WorkspaceName}/${DeploymentProperties.ZipPackageName}")
            }

          }

        }
}