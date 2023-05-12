# Snaaake Game

---

This is the live code created on 2023-05-12 weekly presentation. It's a kotlin native application using ncurses
library to render.

![Snaaake-game](snaaake.png)

### How to build

Using docker:
```shell
docker build . -f Dockerfile -t snaaake-build
docker run --rm -v "$(pwd):/work" -w "/work" snaaake-build gradle build
```

This will build the project and discard all cached tools and dependencies that it downloaded. If you want to retain all that for future builds, you may run it like this:
```shell
# Launches a docker container
docker run -itd --name snaaake-build cat
# Run gradle build on running container
docker exec snaaake-build gradle build
# - or -
# Open an interactive shell to run commands.
docker exec -it snaaake-build bash
> gradle build
```
Then, while the `snaaake-build` container is not deleted, subsequent builds will be faster.

### Generated binaries

The generated binaries can be found at build/bin/native folder. Both a debug and a release executable will be available.

### Credits

Special thanks to Dmitry Kandalov, the original creator of this code. You can see his live coding [here](https://www.youtube.com/watch?v=U-gdJQeOVAk).
