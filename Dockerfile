FROM ghcr.io/graalvm/graalvm-community:21 AS builder

COPY . /build/

WORKDIR /build

RUN ./mvnw --no-transfer-progress native:compile -Pnative  -e

FROM container-registry.oracle.com/os/oraclelinux:9-slim

EXPOSE 8080

COPY --from=0 "/build/target/sb-graalvm-example" sb-graalvm-example

CMD [ "sh", "-c", "./sb-graalvm-example" ]