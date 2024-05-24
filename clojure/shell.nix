{ pkgs ? import <nixpkgs> {} }:
pkgs.mkShell {
  nativeBuildInputs = [
    pkgs.babashka
    pkgs.clojure-lsp
  ];
}
