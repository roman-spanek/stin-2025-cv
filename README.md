# stin-2025-cv

##CV03 REST activation


curl -X POST http://localhost:8081/api/command/switchOn -H "Content-Type: application/json"  -d '{"controlName": "window"}'

##CV01 - SpringBoot REST endpoint


1. setup a new repo in git
2. git config --global user.email "name.surname@tul.cz", git config --global user.name "Name Surname"
3 set ssh keys up (beware of profile in use windows/ubuntu subsystem etc.)  test it > ssh -T git@github.com
4. git clone git@github.com:roman-spanek/STIN-2023-GIT-ACTION.git
5. git checkout -b feature/init-env
6. edit/create a new gitignore file with content being valid for a specific coding laguage and environment
7.  git add .\
    git status\
    git commit -m 'init commit'\
    git push origin feature/init-env
8. create a PR and merge
9. git checkout -b feature/spring-boot-rest-endpoint
10. https://start.spring.io/
11. place zip in project folder
12. unzip to root folder of project
13. open in IDE
14. git add .\
    git status\
    git commit -m 'SpringBoot REST endpoint'\
    git push origin feature/spring-boot-rest-endpoint\
14. or do commit nad push in IDE
