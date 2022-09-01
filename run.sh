#!/usr/bin/env bash

# Dependencies:     maven, docker, docker-desktop


WORKDIR=`pwd`

ld=$(tput bold)
reset=$(tput sgr0)
purple=$(tput setaf 171)
red=$(tput setaf 1)
green=$(tput setaf 76)
tan=$(tput setaf 3)

echo_header() { printf "${bold}${purple}==========  %s  ==========${reset}\n\n" "$@"
}
echo_success() { printf "${green}✔️ %s${reset}\n\n" "$@"
}
echo_error() { printf "${red}✖️ %s${reset}\n\n" "$@"
}
echo_warning() { printf "${tan}➜ %s${reset}\n\n" "$@"
}
echo_purple() { printf "${purple}➜ %s${reset}\n\n" "$@"
}

echo_header "Starting..."
sleep 1
# Determine release.
if [ "$(uname)" == "Linux" ]; then
    OS="Linux"
elif [ "$(uname)" == "Darwin" ]; then
    OS="Darwin"
else
    echo_error "This operating system is not supported. The supported operating systems are Linux and Darwin"
    exit 1
fi

if [ "$(uname -m)" == "x86_64" ]; then
    MACHINE="x86_64"
elif [ "$(uname -m)" == "arm64" ]; then
    MACHINE="arm64"
else
    echo_error "This machine architecture is not supported. Currently the supported architectures are x86_64"
    exit 1
fi

echo_purple "the OS type is ${OS} and the architecture is ${MACHINE}"


for package in docker docker-compose mvn sudo; do
    which $package > /dev/null
    if [[ $? -ne 0 ]] ; then
       echo "Unable to continue. Please install $package before proceeding..."
       exit 1
    fi
done

echo_purple "Cleaning up old docker containers"
docker ps -a | grep -E "letsbid|mongodb|exchange" | awk '{print $1}' | xargs docker rm -f > /dev/null
echo_purple "Starting maven cleaning process"
sleep 1
sudo mvn clean > /dev/null
echo_purple "Maven has been cleaned"
sleep 1
echo_purple "Starting maven install process"
sleep 1
mvn install
if [[ ! $? -ne 0 ]] ; then
    sleep 1
    echo_warning "Maven installation has been completed successfully"
else
    exit 1
fi
sleep 1
docker-compose up -d --build

if [[ ! $? -ne 0 ]] ; then
    sleep 1
    echo_warning "Docker compose up"
else
    exit 1
fi
sleep 1
echo_header "The operation has been completed successfully. let's see the output logs"
sleep 1
docker logs --follow letsbid#!/usr/bin/env bash

# This script will install nr-dashboard-hcl-gen tool and convert NR dashboard output json to terraform format
#
# Dependencies:     maven, docker, docker-desktop
# Operating system: Linux or darwin

WORKDIR=`pwd`

ld=$(tput bold)
reset=$(tput sgr0)
purple=$(tput setaf 171)
red=$(tput setaf 1)
green=$(tput setaf 76)
tan=$(tput setaf 3)

echo_header() { printf "${bold}${purple}==========  %s  ==========${reset}\n\n" "$@"
}
echo_success() { printf "${green}✔️ %s${reset}\n\n" "$@"
}
echo_error() { printf "${red}✖️ %s${reset}\n\n" "$@"
}
echo_warning() { printf "${tan}➜ %s${reset}\n\n" "$@"
}
echo_purple() { printf "${purple}➜ %s${reset}\n\n" "$@"
}

echo_header "Starting..."
sleep 1
# Determine release.
if [ "$(uname)" == "Linux" ]; then
    OS="Linux"
elif [ "$(uname)" == "Darwin" ]; then
    OS="Darwin"
else
    echo_error "This operating system is not supported. The supported operating systems are Linux and Darwin"
    exit 1
fi

if [ "$(uname -m)" == "x86_64" ]; then
    MACHINE="x86_64"
elif [ "$(uname -m)" == "arm64" ]; then
    MACHINE="arm64"
else
    echo_error "This machine architecture is not supported. Currently the supported architectures are x86_64"
    exit 1
fi

echo_purple "the OS type is ${OS} and the architecture is ${MACHINE}"


for package in docker docker-compose mvn sudo; do
    which $package > /dev/null
    if [[ $? -ne 0 ]] ; then
       echo "Unable to continue. Please install $package before proceeding..."
       exit 1
    fi
done

echo_purple "Cleaning up old docker containers"
docker ps -a | grep -E "letsbid|mongodb|exchange" | awk '{print $1}' | xargs docker rm -f > /dev/null
echo_purple "Starting maven cleaning process"
sleep 1
sudo mvn clean > /dev/null
echo_purple "Maven has been cleaned"
sleep 1
echo_purple "Starting maven install process"
sleep 1
mvn install
if [[ ! $? -ne 0 ]] ; then
    sleep 1
    echo_warning "Maven installation has been completed successfully"
else
    exit 1
fi
sleep 1
docker-compose up -d --build

if [[ ! $? -ne 0 ]] ; then
    sleep 1
    echo_warning "Docker compose up"
else
    exit 1
fi
sleep 1
echo_header "The operation has been completed successfully. let's see the output logs"
sleep 1
docker logs --follow letsbid