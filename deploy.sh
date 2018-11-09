#!/bin/bash

# Edit this script to define how you want to deploy to your environments.
# The below script content acts as for reference

let DEV="dev"
let STAGING="staging"
let PRODUCTION="production"

usage(){
    echo "Usage: $0 [environment]"
    exit 1
}

if [ $# -ne 1 ]
then
    usage
else
    environment=$1
fi

echo "Deploying to ${environment} environment"

if [ "$environment" = $DEV ]
then
    # steps to deploy to 'dev' environment
    echo "Steps to deploy to Dev environment"
    exit 0
fi

if [ "$environment" = $STAGING ]
then
    # steps to deploy to 'staging' environment
    echo "Steps to deploy to Staging environment"
    exit 0
fi

if [ "$environment" = $PRODUCTION ]
then
    # steps to deploy to 'production' environment
    echo "Steps to deploy to Production environment"
    exit 0
fi

